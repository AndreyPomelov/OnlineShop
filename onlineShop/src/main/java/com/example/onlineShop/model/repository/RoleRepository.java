package com.example.onlineShop.model.repository;

import com.example.onlineShop.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий прав пользователей
 */
public interface RoleRepository extends JpaRepository<Role, String> {
}
