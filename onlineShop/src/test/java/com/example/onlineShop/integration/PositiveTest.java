package com.example.onlineShop.integration;

import com.example.onlineShop.OnlineShopApplicationTests;
import com.example.onlineShop.controller.AuthController;
import com.example.onlineShop.model.entity.Cart;
import com.example.onlineShop.model.entity.User;
import com.example.onlineShop.model.repository.RoleRepository;
import com.example.onlineShop.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.mock;

public class PositiveTest extends OnlineShopApplicationTests {

    private AuthController authController;

    @BeforeEach
    public void setUp() {
        UserRepository mockUserRepository = mock(UserRepository.class);
        RoleRepository mockRoleRepository = mock(RoleRepository.class);
        PasswordEncoder mockPasswordEncoder = mock(PasswordEncoder.class);
        authController = new AuthController(mockUserRepository, mockRoleRepository, mockPasswordEncoder);
    }

    @Test
    public void saveNewUserTest() {
        // TODO
    }
}
