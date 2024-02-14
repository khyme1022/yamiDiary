package com.yamidiary.yamiyami.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "USER_BADGE_INFO")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserBadgeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BADGE_INFO_CODE", nullable = false, updatable = false)
    private int badgeInfoCode; // 뱃지 코드

    @Column(name = "BADGE_NO", nullable = false, updatable = false)
    private int badgeNo; // 뱃지 번호

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @ToString.Exclude
    private User userId; // 회원 / 외래키 User(userId)

    @Column(name = "BADGE_HAVING_YN", nullable = false, columnDefinition = "TINYINT(1) default 0")
    private Boolean badgeHavingYn; // 뱃지 보유 여부 0은 미보유 1은 보유

    @Column(name = "BADGE_ACTIVE_YN", nullable = false, columnDefinition = "TINYINT(1) default 0")
    private Boolean badgeActiveYn; // 뱃지 활성화 여부 0은 비활성화 1은 활성화

}
