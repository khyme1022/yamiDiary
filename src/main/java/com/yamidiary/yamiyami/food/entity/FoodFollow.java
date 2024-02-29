package com.yamidiary.yamiyami.food.entity;

import com.yamidiary.yamiyami.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class FoodFollow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOOD_FOLLOW_CODE", nullable = false, updatable = false)
    private int foodFollowCode; // 식당 회원 팔로우 코드

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    @ToString.Exclude
    private User userId;    // 외래키 (회원 ID)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FOOD_NO")
    @ToString.Exclude
    private Food foodNo;  // 외래키 (음식 번호)
}
