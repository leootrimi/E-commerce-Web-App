package com.eCommerce.eCommerceApp.Exceptions.Product;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) {
        super(message);
    }
}
