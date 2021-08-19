package com.example.onlineShop.model.entity;

import lombok.EqualsAndHashCode;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Класс с полями составного идентификатора прав пользователя
 */
@Embeddable
@EqualsAndHashCode
public class RolePK implements Serializable {

    private String username;
    private String authority;
}
