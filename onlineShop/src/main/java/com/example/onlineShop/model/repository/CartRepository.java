package com.example.onlineShop.model.repository;

import com.example.onlineShop.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий корзин
 */
public interface CartRepository extends JpaRepository<Cart, String> {
}