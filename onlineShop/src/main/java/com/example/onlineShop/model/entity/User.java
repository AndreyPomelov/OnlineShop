package com.example.onlineShop.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Класс, описывающий пользователя
 */
@Data
@Entity
@Table(name = "users")
public class User {

    /**
     * Логин
     */
    @Id
    @Column(name = "username")
    private String login;

    /**
     * Пароль
     */
    @Column(name = "password")
    private String password;

    /**
     * Признак, разрешён ли вход пользователю
     */
    @Column(name = "enabled")
    private int enabled;

    /**
     * Связь пользователя с корзиной
     */
    @OneToMany(mappedBy = "user")
    private List<Cart> cartList;

//    /**
//     * Имя
//     */
//    @Column(name = "first_name")
//    private String firstName;
//
//    /**
//     * Фамилия
//     */
//    @Column(name = "last_name")
//    private String lastName;
//
//    /**
//     * Отчество
//     */
//    @Column(name = "surname")
//    private String surName;
//
//    /**
//     * Адрес электронной почты
//     */
//    @Column(name = "email")
//    private String email;
//
//    /**
//     * Номер телефона
//     */
//    @Column(name = "phone")
//    private String phone;
//
//    /**
//     * Почтовый адрес
//     */
//    @Column(name = "address")
//    private String address;
//
//    /**
//     * Дата рождения
//     */
//    @Column(name = "birth_date")
//    private LocalDate birthDate;
}