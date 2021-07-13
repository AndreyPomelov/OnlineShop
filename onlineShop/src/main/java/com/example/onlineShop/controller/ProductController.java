package com.example.onlineShop.controller;

import com.example.onlineShop.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер
 */
@Controller
@RequiredArgsConstructor
public class ProductController {

    /**
     * Экземпляр репозитория
     */
    private final ProductRepository repository;

    /**
     * Отображение всех продуктов из БД
     *
     * @return Имя файла шаблона
     */
    @GetMapping(value = "")
    public String findAllProducts(Model model) {
        model.addAttribute("products", repository.findAll());
        return "products";
    }
}