package com.example.onlineShop.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

/**
 * Класс, описывающий пользователя
 */
@Data
@Entity
@Table(name = "user")
public class User {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    /**
     * Логин
     */
    @Column(name = "login")
    private String login;

    /**
     * Пароль
     */
    @Column(name = "password")
    private String password;

    /**
     * Имя
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Отчество
     */
    @Column(name = "surname")
    private String surName;

    /**
     * Адрес электронной почты
     */
    @Column(name = "email")
    private String email;

    /**
     * Номер телефона
     */
    @Column(name = "phone")
    private String phone;

    /**
     * Почтовый адрес
     */
    @Column(name = "address")
    private String address;

    /**
     * Дата рождения
     */
    @Column(name = "birth_date")
    private LocalDate birthDate;
}