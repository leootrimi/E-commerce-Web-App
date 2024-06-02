package com.eCommerce.eCommerceApp.Exceptions.Order;

public class OrderCreationException extends RuntimeException {
    public OrderCreationException(String message) {
        super(message);
    }
}