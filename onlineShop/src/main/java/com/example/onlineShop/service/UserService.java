package com.example.onlineShop.service;

import com.example.onlineShop.model.entity.User;
import com.example.onlineShop.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final EntityManager entityManager;

    @Transactional
    public User getByUsername(String username) {
        //entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, username);
        //entityManager.getTransaction().commit();
        return user;
    }
}
