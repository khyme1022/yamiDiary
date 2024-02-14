package com.yamidiary.yamiyami.diary.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="DIARY_PAGE")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiaryPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NO", nullable = false, updatable = false)
    private int diaryPageCode; // 다이어리 페이지 코드

    @ManyToOne
    @JoinColumn(name = "DIARY_NO")
    @ToString.Exclude
    private Diary diaryNo; // 해당 다이어리 번호 / 외래키 Diary(diaryNo)

    @Column(name="DIARY_PAGE", nullable = false)
    private int diaryPage; // 다이어리 페이지

    @Column(name="DIARY_PAGE_CONTENT", nullable = false, columnDefinition = "TEXT")
    private String diaryPageContent; // 다이어리 내용

}
