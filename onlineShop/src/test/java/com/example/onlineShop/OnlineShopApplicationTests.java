package com.example.onlineShop;

import com.example.onlineShop.model.repository.CartRepository;
import com.example.onlineShop.model.repository.ProductRepository;
import com.example.onlineShop.model.repository.RoleRepository;
import com.example.onlineShop.model.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class OnlineShopApplicationTests {

	@Autowired
	protected UserRepository userRepository;

	@Autowired
	protected CartRepository cartRepository;

	@Autowired
	protected RoleRepository roleRepository;

	@Autowired
	protected ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

}
