package com.example.onlineShop.model.repository;

import com.example.onlineShop.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий пользователей
 */
public interface UserRepository extends JpaRepository<User, String> {
     User getByLoginEquals(String username);
}