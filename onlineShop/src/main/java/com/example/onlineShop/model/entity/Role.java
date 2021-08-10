package com.example.onlineShop.model.entity;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Класс, описывающий роли пользователей (права доступа)
 */
@Entity
@Table(name = "authorities")
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
