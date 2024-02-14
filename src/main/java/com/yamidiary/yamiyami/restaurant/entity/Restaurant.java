package com.yamidiary.yamiyami.restaurant.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "RESTAURANT")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESTAURANT_NO", nullable = false, updatable = false)
    private int restaurantNo; // 식당 번호

    @Column(name = "RESTAURANT_NAME", nullable = false)
    private String restaurantName; // 식당 이름

    @Column(name = "LOCATION_X", nullable = false)
    private Float locationX; // 경도

    @Column(name = "LOCATION_Y", nullable = false)
    private Float locationY; // 위도

}
