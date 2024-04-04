package com.foodorderingservice.restaurantservice.service;

import com.foodorderingservice.restaurantservice.dto.menuItems.MenuItemsRequest;
import com.foodorderingservice.restaurantservice.dto.restaurant.RestaurantRequest;
import com.foodorderingservice.restaurantservice.model.MenuItems;
import com.foodorderingservice.restaurantservice.model.Restaurant;
import com.foodorderingservice.restaurantservice.repository.MenuItemRepository;
import com.foodorderingservice.restaurantservice.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MenuItemRepository menuItemRepository;

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

    public Restaurant getRestaurant(Long restaurantId){
      Optional<Restaurant> restaurantResponse = restaurantRepository.findById(restaurantId);
      if(restaurantResponse.isPresent()){
          return restaurantResponse.get();
      }else{
          throw new ResourceAccessException("Restaurant with ID {} not found"+ restaurantId);
      }
    }

    public List<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
    }

    public boolean addMenuItems(Long restaurantId, MenuItemsRequest menuItemsRequest){
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if(restaurant.isPresent()){
            MenuItems newMenuItems = MenuItems.builder()
                    .foodName(menuItemsRequest.getFoodName())
                    .foodPrice(menuItemsRequest.getFoodPrice())
                    .build();

            newMenuItems.setRestaurant(restaurant.get());
            log.info("menu item {} added successfully",newMenuItems.getFoodName());
            menuItemRepository.save(newMenuItems);
            return true;

        }
        else {
            throw new NoSuchElementException("No restaurant founf with ID {}"+restaurantId);
        }

    }
}
