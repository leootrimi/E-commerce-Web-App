package com.eCommerce.eCommerceApp.Exceptions.Cart;

public class ProductRemovalFromCartException extends RuntimeException {
    public ProductRemovalFromCartException(String message) {
        super(message);
    }
}