package com.yamidiary.yamiyami.food.entity;

import com.yamidiary.yamiyami.diary.entity.Diary;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "FOOD_ADD")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class FoodAdd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOOD_FOLLOW_CODE", nullable = false, updatable = false)
    private int foodFollowCode; // 음식 일기 연결 코드

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DIARY_NO")
    @ToString.Exclude
    private Diary diaryNo; // 외래키 (일기 번호)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FOOD_NO")
    @ToString.Exclude
    private Food foodNo; // 외래키 (음식 번호)
}
