package com.example.onlineShop.controller;

import com.example.onlineShop.model.entity.Cart;
import com.example.onlineShop.model.entity.Product;
import com.example.onlineShop.model.entity.User;
import com.example.onlineShop.model.repository.ProductRepository;
import com.example.onlineShop.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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
     * Экземпляр репозитория товаров
     */
    private final ProductRepository productRepository;

    /**
     * Экземпляр репозитория пользователей
     */
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

    /**
     * Отображение списка пользователей
     *
     * @param model Модель для добавления атрибутов
     * @return Имя файла шаблона
     */
    @GetMapping(value = "/users")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String findAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    /**
     * Метод, добавляющий указанный товар в корзину
     *
     * @param id Идентификатор товара
     * @return Имя файла шаблона
     */
    @GetMapping(value = {"/toCart/{id}"})
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    public String toCart(@PathVariable int id) {
        //TODO Дописать метод
        Product product = productRepository.getById(id);
        String username = currentUserName();
        // TODO Следующая строка вызывает
        // TODO TypeMismatchException: Provided id of the wrong type for class com.example.onlineShop.model.entity.Cart. Expected: class java.lang.Integer, got class java.lang.String
        // TODO Что-то не так с инициализацией корзины, принадлежащей пользователю. Разобраться
        User user = userRepository.getById(username);
        Cart cart = user.getCart();
        return "redirect:/products";
    }

    /**
     * Метод, возвращающий имя текущего пользователя
     * 
     * @return Имя пользователя
     */
    private String currentUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    /**
     * Временный тестовый метод для вывода объекта в консоль
     *
     * @param o Передаваемый объект
     */
    private void test(Object o) {
        System.out.println("TEST");
        System.out.println(o);
        System.out.println("TEST");
    }
}