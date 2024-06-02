package com.eCommerce.eCommerceApp.Exceptions.Users;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
