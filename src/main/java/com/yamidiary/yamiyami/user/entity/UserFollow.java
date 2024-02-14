package com.yamidiary.yamiyami.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="USER_FOLLOW")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFollow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOLLOW_USER_CODE", nullable = false, updatable = false)
    private int followUserCode; // 팔로우 관계 기본키

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @ToString.Exclude
    private User userId; // 회원 아이디

    @ManyToOne
    @JoinColumn(name = "FOLLOW_USER_ID")
    @ToString.Exclude
    private User followUserId; // 팔로우한 유저 아이디
}
