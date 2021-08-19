package com.example.onlineShop.model.repository;

import com.example.onlineShop.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
