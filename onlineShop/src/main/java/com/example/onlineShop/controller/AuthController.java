package com.example.onlineShop.controller;

import com.example.onlineShop.model.entity.Role;
import com.example.onlineShop.model.entity.User;
import com.example.onlineShop.model.repository.RoleRepository;
import com.example.onlineShop.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Контроллер авторизации и регистрации
 */
@Controller
@RequiredArgsConstructor
public class AuthController {

    /**
     * Экземпляр репозитория пользователей
     */
    private final UserRepository userRepository;

    /**
     * Экземпляр репозитория прав пользователей
     */
    private final RoleRepository roleRepository;

    /**
     * Экземпляр энкодера для пользовательских паролей
     */
    private final PasswordEncoder passwordEncoder;

    /**
     * Права стандартного пользователя
     */
    private final String ROLE_USER = "ROLE_USER";

    /**
     * Метод, открывающий страницу авторизации
     *
     * @return Имя файла шаблона
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Переход на страницу регистрации
     *
     * @return Имя файла шаблона
     */
    @GetMapping(value = "/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    /**
     * Сохранение нового пользователя в БД при регистрации
     *
     * @param user Экземпляр нового пользователя
     * @return Имя файла шаблона
     */
    @PostMapping(value = "/register")
    public String saveNewUser(User user) {
        if (userRepository.existsById(user.getLogin())) {
            System.err.printf("Registration failed, username - %s%n", user.getLogin());
            return "reg_denied";
        }
        user.setEnabled(1);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        sendRegData(user);
        saveNewUserRole(user.getLogin());
        return "reg_success";
    }

    /**
     * Отправка регистрационных данных пользователю на e-mail
     *
     * @param user Экземпляр пользователя
     */
    private void sendRegData(User user) {
        //TODO
    }

    /**
     * Сохранение прав доступа нового пользователя в БД
     *
     * @param username Имя пользователя
     */
    private void saveNewUserRole(String username) {
        Role role = new Role();
        role.setUsername(username);
        role.setAuthority(ROLE_USER);
        roleRepository.save(role);
    }
}
