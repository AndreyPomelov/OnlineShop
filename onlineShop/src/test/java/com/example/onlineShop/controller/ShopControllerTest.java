package com.example.onlineShop.controller;

import com.example.onlineShop.model.repository.ProductRepository;
import com.example.onlineShop.model.repository.UserRepository;
import com.example.onlineShop.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class ShopControllerTest {

    private ShopController shopController;

    @BeforeEach
    public void setUp() {
        ProductRepository mockProductRepository = mock(ProductRepository.class);
        UserRepository mockUserRepository = mock(UserRepository.class);
        UserService mockUserService = mock(UserService.class);
        //shopController = new ShopController(mockProductRepository, mockUserRepository, mockUserService);
    }

    @Test
    public void findAllProductsTest() {
        String actual = shopController.findAllProducts(new ConcurrentModel());
        assertNotNull(actual);
        assertEquals("products", actual);
    }

    @Test
    public void mainPageTest() {
        String actual = shopController.mainPage();
        assertNotNull(actual);
        assertEquals("index", actual);
    }

    @Test
    public void findAllUsersTest() {
        String actual = shopController.findAllUsers(new ConcurrentModel());
        assertNotNull(actual);
        assertEquals("users", actual);
    }

}