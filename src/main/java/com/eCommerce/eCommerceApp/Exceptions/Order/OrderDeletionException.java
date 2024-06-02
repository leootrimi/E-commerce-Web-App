package com.eCommerce.eCommerceApp.Exceptions.Order;

public class OrderDeletionException extends RuntimeException {
    public OrderDeletionException(String message) {
        super(message);
    }
}