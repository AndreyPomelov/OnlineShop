package com.example.onlineShop.controller;

import com.example.onlineShop.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Главный контроллер
 */
@Controller
@RequiredArgsConstructor
public class ShopController {

    /**
     * Экземпляр репозитория
     */
    private final ProductRepository repository;

    /**
     * Отображение всех продуктов из БД
     *
     * @return Имя файла шаблона
     */
    @GetMapping(value = "/products")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String findAllProducts(Model model) {
        model.addAttribute("products", repository.findAll());
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
    @GetMapping(value = "index")
    public String mainPage() {
        return "index";
    }
}