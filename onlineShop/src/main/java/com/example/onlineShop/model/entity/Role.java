package com.example.onlineShop.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Класс, описывающий роли пользователей
 */
@Data
@Entity
@Table(name = "role")
public class Role {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

    /**
     * Название роли пользователя
     */
    @Column(name = "name")
    private String name;

    /**
     * Связываем роль с пользователями
     * @see User
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
}
