package com.example.onlineShop.controller;

import com.example.onlineShop.model.entity.Product;
import com.example.onlineShop.model.repository.OrderRepository;
import com.example.onlineShop.model.repository.ProductRepository;
import com.example.onlineShop.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Контроллер функционала администратора
 */
@Controller
@RequiredArgsConstructor
public class AdminController {

    /**
     * Экземпляр репозитория товаров
     */
    private final ProductRepository productRepository;

    /**
     * Экземпляр репозитория пользователей
     */
    private final UserRepository userRepository;

    /**
     * Экземпляр репозитория истории заказов
     */
    private final OrderRepository orderRepository;

    /**
     * Переход к панели администратора
     *
     * @return Имя файла шаблона
     */
    @GetMapping(value = "/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminPanel() {
        return "admin_panel";
    }

    /**
     * Отображение списка незаблокированных пользователей
     *
     * @param model Модель для добавления атрибутов
     * @return Имя файла шаблона
     */
    @GetMapping(value = "/users")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String findAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll()
                .stream().filter(x -> x.getEnabled() == 1)
                .collect(Collectors.toList()));
        return "users";
    }

    /**
     * Блокировка пользователя
     *
     * @param id Идентификатор пользователя
     * @return Имя файла шаблона
     */
    @GetMapping(value = {"/blockUser/{id}"})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @Transactional
    public String blockUser(@PathVariable String id) {
        userRepository.getById(id).setEnabled(0);
        return "blocked";
    }

    /**
     * Отображение списка заблокированных пользователей
     *
     * @param model Модель для добавления атрибутов
     * @return Имя файла шаблона
     */
    @GetMapping(value = "/banned")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String banList(Model model) {
        model.addAttribute("users", userRepository.findAll()
                .stream().filter(x -> x.getEnabled() == 0)
                .collect(Collectors.toList()));
        return "banned";
    }

    /**
     * Разблокировка пользователя
     *
     * @param id Идентификатор пользователя
     * @return Имя файла шаблона
     */
    @GetMapping(value = {"/unblockUser/{id}"})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @Transactional
    public String unblockUser(@PathVariable String id) {
        userRepository.getById(id).setEnabled(1);
        return "unblocked";
    }

    /**
     * Добавление нового продукта в БД
     *
     * @param model Модель для добавления атрибутов
     * @return Имя файла шаблона
     */
    @GetMapping(value = "/add_product")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "add_product";
    }

    @PostMapping(value = "/add_product")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addProduct(Product product) {
        product.setId(UUID.randomUUID().toString());
        productRepository.save(product);
        return "product_added";
    }
}
