package com.foodorderingservice.restaurantservice.service;

import com.foodorderingservice.restaurantservice.dto.menuItems.MenuItemsRequest;
import com.foodorderingservice.restaurantservice.dto.restaurant.RestaurantRequest;
import com.foodorderingservice.restaurantservice.model.MenuItems;
import com.foodorderingservice.restaurantservice.model.Restaurant;
import com.foodorderingservice.restaurantservice.repository.MenuItemRepository;
import com.foodorderingservice.restaurantservice.repository.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    public final MenuItemRepository menuItemRepository;

    public Restaurant createRestaurant(RestaurantRequest restaurantRequest){
        Restaurant restaurant = Restaurant.builder()
                .restaurantName(restaurantRequest.getRestaurantName())
                .restaurantAddress(restaurantRequest.getRestaurantAddress())
                .district(restaurantRequest.getDistrict())
                .fssaiNumber(restaurantRequest.getFssaiNumber())
                .panNumber(restaurantRequest.getPanNumber())
                .gstNumber(restaurantRequest.getGstNumber())
                .pincode(restaurantRequest.getPincode())
                .build();

        log.info("restaurant {} saved successfully",restaurant.getRestaurantName());
        return restaurantRepository.save(restaurant);
    }

    public MenuItems addMenuItems(Long restaurantId, MenuItemsRequest menuItemsRequest){
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        MenuItems newMenuItems = MenuItems.builder()
                .foodName(menuItemsRequest.getFoodName())
                .foodPrice(menuItemsRequest.getFoodPrice())
                .build();

        newMenuItems.setRestaurant(restaurant);
        log.info("menu item {} added succeefully",newMenuItems.getFoodName());
        return menuItemRepository.save(newMenuItems);

//        if(restaurantId != null){
//            menuItemsRequest.setRestaurant(restaurant);
//            MenuItems menuItems = MenuItems.builder()
//                    .foodName(menuItemsRequest.getFoodName())
//                    .foodPrice(menuItemsRequest.getFoodPrice()).build();
//
//            menuItemRepository.save(menuItems);
//        }
//
    }
}
