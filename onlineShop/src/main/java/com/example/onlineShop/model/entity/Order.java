package com.example.onlineShop.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
 * Класс, описывающий совершённый заказ в истории заказов
 */
@Data
@Entity
@Table(name = "order_history")
public class Order {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Дата и время заказа
     */
    @Column(name = "date")
    private Date date;

    /**
     * Пользователь, оформивший заказ
     */
    @Column(name = "username")
    private String username;

    /**
     * Приобретённый продукт
     */
    @Column(name = "product_id")
    private String productId;

    /**
     * Стоимость продукта на момент заказа
     */
    @Column(name = "price")
    private double price;
}
