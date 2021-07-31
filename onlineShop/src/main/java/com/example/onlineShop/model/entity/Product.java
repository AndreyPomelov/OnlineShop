package com.example.onlineShop.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

/**
 * Класс, описывающий товар
 */
@Data
@Entity
@Table(name = "product")
public class Product {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    /**
     * Название
     */
    @Column(name = "title")
    private String title;

    /**
     * Описание
     */
    @Column(name = "description")
    private String description;

    /**
     * Цена
     */
    @Column(name = "price")
    private double price;

    /**
     * Ссылка на фотографию
     */
    @Column(name = "photo")
    private String photoLink;

    /**
     * Список корзин, в которых находится данный товар
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id")
    )
    private List<Cart> carts;
}