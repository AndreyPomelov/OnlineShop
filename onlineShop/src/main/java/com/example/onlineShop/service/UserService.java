package com.example.onlineShop.service;

import com.example.onlineShop.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Репозиторий пользователей
 * Пока тестовый вариант
 * Возможно не понадобится
 */
@Service
@RequiredArgsConstructor
public class UserService {

    /**
     * Экземпляр менеджера сущностей
     */
    private final EntityManager entityManager;

    /**
     * Метод, находящий пользователя в БД по логину
     *
     * @param username Логин
     * @return Найденный пользователь
     */
    @Transactional
    public User getByUsername(String username) {
        User user = entityManager.find(User.class, username);
        return user;
    }
}
