package com.example.onlineShop.data;

/**
 * Перечисление возможных статусов заказа товара
 */
public enum OrderStatus {

    ORDERED (1),
    CANCELED (0);

    private final int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}