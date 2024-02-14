package com.yamidiary.yamiyami.user.entity;

import com.yamidiary.yamiyami.restaurant.entity.Restaurant;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class RestaurantFollow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESTAURANT_FOLLOW_CODE", nullable = false, updatable = false)
    private int restaurantFollowCode; // 식당 회원 팔로우 코드

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @ToString.Exclude
    private User userId; // 외래키 (회원 ID)

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_NO")
    @ToString.Exclude
    private Restaurant restaurantNo; // 외래키 (식당 번호)
}
