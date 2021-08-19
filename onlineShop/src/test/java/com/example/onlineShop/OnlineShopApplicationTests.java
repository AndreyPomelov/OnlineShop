package com.example.onlineShop;

import com.example.onlineShop.model.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OnlineShopApplicationTests {

	@Autowired
	protected UserRepository userRepository;

	@Test
	void contextLoads() {
	}

}
