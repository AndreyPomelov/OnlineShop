package com.example.onlineShop.model.entity;

import lombok.Data;
import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;
}
