package com.yamidiary.yamiyami.badge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="BADGE")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BADGE_NO", nullable = false, updatable = false)
    private int badgeNo; // 뱃지 번호

    @Column(name = "BADGE_NAME", nullable = false)
    private String badgeName; // 뱃지 이름

    @Column(name = "BADGE_IMAGE_URL", nullable = false)
    private String badgeImageUrl; // 뱃지 URL
}
