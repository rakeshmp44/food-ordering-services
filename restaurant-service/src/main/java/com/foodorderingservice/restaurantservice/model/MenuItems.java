package com.foodorderingservice.restaurantservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Optional;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MenuItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;
    private String foodName;
    private BigDecimal foodPrice;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = true)
    private Restaurant restaurant;

}
