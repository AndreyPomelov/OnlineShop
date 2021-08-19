package com.example.onlineShop.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "order_history")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date")
    private Date date;

    @Column(name = "username")
    private String username;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "price")
    private double price;
}
