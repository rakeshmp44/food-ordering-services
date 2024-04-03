package com.foodorderingservice.restaurantservice.repository;

import com.foodorderingservice.restaurantservice.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Restaurant findByRestaurantId(Long restaurantId);
}
