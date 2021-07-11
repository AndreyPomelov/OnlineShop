package com.example.onlineShop.model.repository;

import com.example.onlineShop.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий ролей пользователей
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
}