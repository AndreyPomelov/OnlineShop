package com.example.onlineShop.controller;

import com.example.onlineShop.model.repository.RoleRepository;
import com.example.onlineShop.model.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ConcurrentModel;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class AuthControllerTest {

    private AuthController authController;

    @BeforeEach
    public void setUp() {
        UserRepository mockUserRepository = mock(UserRepository.class);
        RoleRepository mockRoleRepository = mock(RoleRepository.class);
        PasswordEncoder mockPasswordEncoder = mock(PasswordEncoder.class);
        authController = new AuthController(mockUserRepository, mockRoleRepository, mockPasswordEncoder);
    }

    @Test
    public void loginTest() {
        String actual = authController.login();
        assertNotNull(actual);
        // Далее два способа проверки с помощью разных библиотек
        assertEquals("login", actual);
        assertThat(actual).isEqualTo("login");
    }

    @Test
    public void registerTest() {
        String actual = authController.register(new ConcurrentModel());
        assertNotNull(actual);
        assertEquals("register", actual);
    }

}