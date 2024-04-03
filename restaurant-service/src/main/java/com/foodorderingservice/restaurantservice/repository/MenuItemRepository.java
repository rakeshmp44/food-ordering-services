package com.foodorderingservice.restaurantservice.repository;

import com.foodorderingservice.restaurantservice.model.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItems, Long> {
}
