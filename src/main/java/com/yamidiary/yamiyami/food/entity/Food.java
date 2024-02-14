package com.yamidiary.yamiyami.food.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="FOOD")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOOD_NO", nullable = false,updatable = false)
    private int foodNo; // 음식 번호

    @Column(name = "FOOD_NAME", nullable = false, unique = true)
    private String foodName; // 음식 이름
}
