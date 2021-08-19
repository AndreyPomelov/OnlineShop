package com.example.onlineShop.model.entity;

import lombok.Data;
import javax.persistence.*;

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
    @Column(name = "enabled", columnDefinition = "Tinyint(1) default '0'")
    private int enabled;

    /**
     * Связь пользователя с корзиной
     */
    @OneToOne(mappedBy = "user")
    private Cart cart;

    //TODO Реализовать следующие поля в БД
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