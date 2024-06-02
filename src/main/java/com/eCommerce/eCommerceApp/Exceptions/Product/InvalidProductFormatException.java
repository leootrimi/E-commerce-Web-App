package com.eCommerce.eCommerceApp.Exceptions.Product;

public class InvalidProductFormatException extends RuntimeException {
    public InvalidProductFormatException(String message) {
        super(message);
    }
}
