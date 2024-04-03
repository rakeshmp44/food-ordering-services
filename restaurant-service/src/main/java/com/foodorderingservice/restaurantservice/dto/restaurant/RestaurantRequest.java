package com.foodorderingservice.restaurantservice.dto.restaurant;

import com.foodorderingservice.restaurantservice.model.MenuItems;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RestaurantRequest {
    private String restaurantName;
    private String restaurantAddress;
    private String district;
    private String panNumber;
    private String fssaiNumber;
    private String gstNumber;
    private String pincode;

}
