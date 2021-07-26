package com.example.onlineShop.controller;

import com.example.onlineShop.model.entity.Product;
import com.example.onlineShop.model.repository.ProductRepository;
import com.example.onlineShop.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Главный контроллер
 */
@Controller
@RequiredArgsConstructor
public class ShopController {

    /**
     * Экземпляр репозитория
     */
    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    /**
     * Отображение всех продуктов из БД
     *
     * @return Имя файла шаблона
     */
    @GetMapping(value = "/products")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    public String findAllProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    /**
     * Переход на страницу регистрации
     *
     * @return Имя файла шаблона
     */
    @GetMapping(value = "/register")
    public String register() {
        return "register";
    }

    /**
     * Переход на главную страницу
     *
     * @return Имя файла шаблона
     */
    @GetMapping(value = "")
    public String mainPage() {
        return "index";
    }

    @GetMapping(value = "/users")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String findAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @GetMapping(value = {"/toCart/{id}"})
    public String toCart(@PathVariable int id) {
        //TODO Дописать метод
        System.out.println("Вызван метод добавления в корзину, ИД товара - " + id);
        Product product = productRepository.getById(id);
        return "redirect:/products";
    }
}