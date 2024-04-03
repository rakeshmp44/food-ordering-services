package com.foodorderingservice.restaurantservice.controller;

import com.foodorderingservice.restaurantservice.dto.menuItems.MenuItemsRequest;
import com.foodorderingservice.restaurantservice.dto.restaurant.RestaurantRequest;
import com.foodorderingservice.restaurantservice.model.MenuItems;
import com.foodorderingservice.restaurantservice.model.Restaurant;
import com.foodorderingservice.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant createRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        return restaurantService.createRestaurant(restaurantRequest);
    }
    @PostMapping("/{restaurantId}/addmenu")
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant addMenuItems(@PathVariable Long restaurantId,@RequestBody MenuItemsRequest menuItemsRequest){
        return restaurantService.addMenuItems(restaurantId,menuItemsRequest);
    }
}
