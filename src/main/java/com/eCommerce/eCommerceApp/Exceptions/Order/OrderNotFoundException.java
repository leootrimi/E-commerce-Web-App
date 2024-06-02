package com.eCommerce.eCommerceApp.Exceptions.Order;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }
}