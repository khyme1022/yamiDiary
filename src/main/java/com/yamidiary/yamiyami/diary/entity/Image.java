package com.yamidiary.yamiyami.diary.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="IMAGE")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IMAGE_NO",nullable = false,updatable = false)
    private int imageNo; // 이미지 번호

    @ManyToOne
    @JoinColumn(name = "DIARY_NO")
    @ToString.Exclude
    private Diary diaryNo; // 외래키 Diary(diaryNo)

    @Column(name = "IMAGE_URL", nullable = false, columnDefinition = "VARCHAR(200)")
    private String imageURL; // 이미지 URL
}
