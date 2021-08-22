package com.example.onlineShop.controller;

import com.example.onlineShop.data.OrderStatus;
import com.example.onlineShop.model.entity.Cart;
import com.example.onlineShop.model.entity.Order;
import com.example.onlineShop.model.entity.Product;
import com.example.onlineShop.model.entity.User;
import com.example.onlineShop.model.repository.OrderRepository;
import com.example.onlineShop.model.repository.ProductRepository;
import com.example.onlineShop.model.repository.UserRepository;
import com.example.onlineShop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Date;
import java.util.List;

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
     * Экземпляр репозитория истории заказов
     */
    private final OrderRepository orderRepository;

    /**
     * Экземпляр сервиса пользователей
     * Пока как тест. Возможно не понадобится
     */
    private final UserService userService;

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
     * Только для пользователей с правами админа
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
    @Transactional
    public String toCart(@PathVariable String id) {
        Product product = productRepository.getById(id);
        User user = userRepository.getById(currentUserName());
        Cart cart = user.getCart();
        cart.getProducts().add(product);
        return "added";
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

    /**
     * Отображение на экране корзины пользователя
     *
     * @param model Модель для добавления атрибутов
     * @return Имя файла шаблона
     */
    @GetMapping(value = "/cart")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    public String showCart(Model model) {
        List<Product> products = userRepository.getById(currentUserName()).getCart().getProducts();
        model.addAttribute("products", products);
        double sum = products.stream().mapToDouble(Product::getPrice).sum();
        model.addAttribute("sum", sum);
        return "cart";
    }

    /**
     * Удаление указанного товара из корзины
     *
     * @param id Идентификатор товара
     * @return Имя файла шаблона
     */
    @GetMapping(value = {"/removeFromCart/{id}"})
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @Transactional
    public String removeFromCart(@PathVariable String id) {
        Product product = productRepository.getById(id);
        User user = userRepository.getById(currentUserName());
        Cart cart = user.getCart();
        cart.getProducts().remove(product);
        saveOrderHistory(List.of(product), OrderStatus.CANCELED);
        return "removed";
    }

    /**
     * Оформление заказа,
     * перенос заказа в историю заказов
     * и очистка корзины
     *
     * @param model Модель для добавления атрибутов
     * @return Имя файла шаблона
     */
    @GetMapping(value = "/order")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @Transactional
    public String order(Model model) {
        List<Product> products = userRepository.getById(currentUserName()).getCart().getProducts();
        model.addAttribute("products", products);
        double sum = products.stream().mapToDouble(Product::getPrice).sum();
        model.addAttribute("sum", sum);
        saveOrderHistory(products, OrderStatus.ORDERED);
        userRepository.getById(currentUserName()).getCart().getProducts().clear();
        return "order";
    }

    /**
     * Сохранение заказа в истории заказов
     *
     * @param products Список продуктов в оформленном заказе
     */
    private void saveOrderHistory(List<Product> products, OrderStatus status) {
        for (Product product : products) {
            Order order = new Order();
            order.setUsername(currentUserName());
            order.setProductId(product.getId());
            order.setPrice(product.getPrice());
            order.setDate(new Date());
            order.setOrderStatus(status.getValue());
            orderRepository.save(order);
        }
    }

    @GetMapping(value = "/clear")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @Transactional
    public String clearCart() {
        List<Product> products = userRepository.getById(currentUserName()).getCart().getProducts();
        saveOrderHistory(products, OrderStatus.CANCELED);
        products.clear();
        return "cart_clear";
    }
}