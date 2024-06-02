package com.eCommerce.eCommerceApp.Exceptions.Payment;

public class PaymentDeletionException extends RuntimeException {
    public PaymentDeletionException(String message) {
        super(message);
    }
}