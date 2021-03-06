package com.example.onlineShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Главный класс приложения
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class OnlineShopApplication {

	/**
	 * Точка входа
	 *
	 * @param args Аргументы, передаваемые при запуске приложения
	 */
	public static void main(String[] args) {
		SpringApplication.run(OnlineShopApplication.class, args);
	}

}