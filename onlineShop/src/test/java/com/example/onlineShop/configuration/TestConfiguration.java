package com.example.onlineShop.configuration;

import com.example.onlineShop.model.repository.CartRepository;
import com.example.onlineShop.model.repository.ProductRepository;
import com.example.onlineShop.model.repository.RoleRepository;
import com.example.onlineShop.model.repository.UserRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TestConfiguration {

    @Bean
    @Primary
    public UserRepository userRepositoryTest() {
        return Mockito.mock(UserRepository.class);
    }

    @Bean
    @Primary
    public CartRepository cartRepositoryTest() {
        return Mockito.mock(CartRepository.class);
    }

    @Bean
    @Primary
    public ProductRepository productRepositoryTest() {
        return Mockito.mock(ProductRepository.class);
    }

    @Bean
    @Primary
    public RoleRepository roleRepositoryTest() {
        return Mockito.mock(RoleRepository.class);
    }
}
