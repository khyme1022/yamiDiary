package com.yamidiary.yamiyami.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider){
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String token = jwtTokenProvider.resolveToken(request);
        LOGGER.info("[doFilterInternal] token 값 추출 완료 , .token : {}", token);
        LOGGER.info("[doFilterInternal] token 값 유효성 체크 시작");
        if (token != null && jwtTokenProvider.validateToken(token)) { // token이 유효한 토큰일 시에만 유효성 체크
            Authentication authentication = jwtTokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            LOGGER.info("[doFilterInternal] token 값 유효성 체크 완료");
        }
        filterChain.doFilter(request, response);
        //doFilter 메소드 설정 시 request, response 쌍이 지나갈 때마다 컨테이너에서 실행되게 된다.
    }
}
