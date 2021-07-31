package com.example.onlineShop.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

/**
 * Класс, описывающий корзину с товарами
 */
@Data
@Entity
@Table(name = "cart")
public class Cart {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int id;

    /**
     * Пользователь, которому принадлежит данная корзина
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private User user;

    /**
     * Лист товаров, находящихся в данной корзине
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
}
