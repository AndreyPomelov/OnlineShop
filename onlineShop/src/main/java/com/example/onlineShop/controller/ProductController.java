package com.example.onlineShop.controller;

import com.example.onlineShop.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository repository;

    @GetMapping(value = "products")
    public String findAllProducts(Model model) {
        model.addAttribute("products", repository.findAll());
        return "products";
    }
}