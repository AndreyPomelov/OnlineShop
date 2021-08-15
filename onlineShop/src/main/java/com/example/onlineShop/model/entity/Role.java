package com.example.onlineShop.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Класс, описывающий роли пользователей (права доступа)
 */
@Data
@Entity
@Table(name = "authorities")
@IdClass(RolePK.class)
public class Role implements Serializable {

    /**
     * Имя пользователя (логин)
     */
    @Id
    @Column(name = "username")
    private String username;

    /**
     * Роль пользователя (права доступа)
     */
    @Id
    @Column(name = "authority")
    private String authority;
}
