package com.eCommerce.eCommerceApp.Exceptions.ProductSold;

public class TotalPriceCalculationException extends RuntimeException {
    public TotalPriceCalculationException(String message) {
        super(message);
    }
}