package com.example.onlineShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер авторизации
 */
@Controller
public class AuthController {

    /**
     * Метод, открывающий страницу авторизации
     *
     * @return Имя файла шаблона
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
