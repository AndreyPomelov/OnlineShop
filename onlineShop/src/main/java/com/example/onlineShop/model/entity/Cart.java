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
    @Column(name = "cart_id")
    private String id;

    /**
     * Пользователь, которому принадлежит данная корзина
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private User user;

    /**
     * Лист товаров, находящихся в данной корзине
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
}
