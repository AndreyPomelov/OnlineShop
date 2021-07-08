package com.example.onlineShop.model.repository;

import com.example.onlineShop.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}