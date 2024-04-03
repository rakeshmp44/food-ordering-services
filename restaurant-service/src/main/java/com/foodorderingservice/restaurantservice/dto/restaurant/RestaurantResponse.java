package com.foodorderingservice.restaurantservice.dto.restaurant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RestaurantResponse {
    private Long restaurantId;
    private String restaurantName;
    private String restaurantAddress;
    private String district;
    private String panNumber;
    private String fssaiNumber;
    private String gstNumber;
    private String pincode;

}
