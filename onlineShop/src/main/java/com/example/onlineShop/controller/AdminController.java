package com.example.onlineShop.controller;

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
    public String toCart(@PathVariable String id) {
        userRepository.getById(id).setEnabled(0);
        return "blocked";
    }
}
