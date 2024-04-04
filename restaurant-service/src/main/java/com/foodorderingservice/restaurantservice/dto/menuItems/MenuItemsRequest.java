package com.foodorderingservice.restaurantservice.dto.menuItems;

import com.foodorderingservice.restaurantservice.model.MenuItems;
import com.foodorderingservice.restaurantservice.model.Restaurant;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MenuItemsRequest{
    private String foodName;
    private BigDecimal foodPrice;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
}
