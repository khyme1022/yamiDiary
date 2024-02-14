package com.yamidiary.yamiyami.diary.entity;

import com.yamidiary.yamiyami.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="RECOMMEND")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recommend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECOMMEND_CODE", nullable = false, updatable = false)
    private int recommendCode; // 추천 기본키

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @ToString.Exclude
    private User userId; // 추천한 사람 / 외래키 User(userId)

    @ManyToOne
    @JoinColumn(name = "DIARY_NO")
    @ToString.Exclude
    private Diary diaryNo; // 해당 게시물 / 외래키 Diary(diaryNo)

}
