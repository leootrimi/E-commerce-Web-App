package com.eCommerce.eCommerceApp.Exceptions.Cart;

public class TotalPriceCalculationException extends RuntimeException {
    public TotalPriceCalculationException(String message) {
        super(message);
    }
}