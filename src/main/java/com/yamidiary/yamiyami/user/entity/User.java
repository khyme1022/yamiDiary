package com.yamidiary.yamiyami.user.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "USER")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false, updatable = false)
    private int userId; // 사용자 고유번호

    @Column(name = "EMAIL", nullable = false, updatable = false, columnDefinition = "VARCHAR(50)", unique = true)
    private String email; // 이메일

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "USER_PW", nullable = false, columnDefinition = "VARCHAR(20)")
    private String userPw; // 비밀번호

    @Column(name = "NICKNAME", nullable = false, columnDefinition = "VARCHAR(20)")
    private String nickname; // 닉네임

    @Column(name = "USER_PRIVATE_DEFAULT_YN", nullable = false, columnDefinition = "TINYINT(1) default 1")
    private Boolean userPrivateDefaultYn; // 유저 공개 설정 - 0이 비공개

    @Column(name = "POST_PRIVATE_DEFAULT_YN", nullable = false, columnDefinition = "TINYINT(1) default 1")
    private Boolean postPrivateDefaultYn; // 게시물 공개 설정 - 0이 비공개

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>(); // 권한 테이블

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    } // 권한 목록 리턴

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public String getUsername() {
        return this.email;
    } // 유저의 이메일 반환

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public String getPassword() {
        return this.userPw;
    } // 유저의 비밀번호 반환

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired() {
        return false;
    } // 유저의 계정이 만료되었는 지 리턴 true 만료되지 않음
    // 
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // 유저의 계정이 잠겨있는 지 리턴 true 잠기지 않음
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    } // 비밀번호 만료 체크

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
        return false;
    } // 계정 활성화 체크

}
