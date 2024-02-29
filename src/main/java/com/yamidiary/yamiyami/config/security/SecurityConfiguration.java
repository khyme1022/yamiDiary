package com.yamidiary.yamiyami.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {
    private final JwtTokenProvider jwtTokenProvider;

    public SecurityConfiguration(JwtTokenProvider jwtTokenProvider){
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .httpBasic(HttpBasicConfigurer::disable) // UI 사용 기본 값으로 가진 시큐리티 설정 비활성화

                .csrf(CsrfConfigurer::disable) // CSRF 보안 비활성화

                .sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                /*
                 *       SessionCreationPolicy.ALWAYS      - 스프링시큐리티가 항상 세션을 생성
                 *       SessionCreationPolicy.IF_REQUIRED - 스프링시큐리티가 필요시 생성(기본)
                 *       SessionCreationPolicy.NEVER       - 스프링시큐리티가 생성하지않지만 기존에 존재하면 사용
                 *       SessionCreationPolicy.STATELESS   - 스프링시큐리티가 생성하지도않고 기존것을 사용하지도 않음
                 */
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                )
                /*
                 * authorizeRequests() 애플리케이션에 들어오는 요청에 대한 사용 권한 체크
                 * antMatchers() antPattern을 통해 권한을 설정하는 역할
                 * permitAll()
                 * anyRequest().hasRole("ADMIN") - ADMIN 권한을 가진 사람에게만
                 */

                .exceptionHandling(authenticationManager -> authenticationManager
                        .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
                        .accessDeniedHandler(new CustomAccessDeniedHandler()))
                // 권한 확인 중 예외 발생할 경우 CustomAccessDeniedHandler()로 예외 전달
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
        // 필터 등록을 어느 필터 앞에 추가할 것인지 설정한다.
        // JwtAuthenticationFilter를 UsernamePasswordAuthenticationFilter 앞에 추가하겠다는 의미

        return httpSecurity.build();

    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers(
                        "/v3/api-docs/**", "/swagger-resources/**",
                        "/swagger-ui.html","/webjars/**", "sign-api/exception","/swagger-ui/**");

    }

    //패스워드 암호화 저장을 위한 빈


}
