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
public class MenuItemsRequest extends MenuItems {
    private String foodName;
    private BigDecimal foodPrice;

}
