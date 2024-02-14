package com.yamidiary.yamiyami.diary.entity;

import com.yamidiary.yamiyami.restaurant.entity.Restaurant;
import com.yamidiary.yamiyami.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "RESTAURANT_ADD")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantAdd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESTAURANT_FOLLOW_CODE", nullable = false, updatable = false)
    private int restaurantFollowCode; // 식당 일기 연결 코드

    @ManyToOne
    @JoinColumn(name = "DIARY_NO")
    @ToString.Exclude
    private Diary diaryNo;  // 외래키 (일기 번호)

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_NO")
    @ToString.Exclude
    private Restaurant restaurantNo;  // 외래키 (식당 번호)
}
