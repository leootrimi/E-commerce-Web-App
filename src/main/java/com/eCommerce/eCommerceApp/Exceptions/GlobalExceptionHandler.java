package com.eCommerce.eCommerceApp.Exceptions;

import com.eCommerce.eCommerceApp.Exceptions.Cart.CartCountRetrivalException;
import com.eCommerce.eCommerceApp.Exceptions.Cart.ProductRemovalFromCartException;
import com.eCommerce.eCommerceApp.Exceptions.Cart.ProductsRetrievalByUsernameException;
import com.eCommerce.eCommerceApp.Exceptions.Cart.TotalPriceCalculationException;
import com.eCommerce.eCommerceApp.Exceptions.Order.OrderCreationException;
import com.eCommerce.eCommerceApp.Exceptions.Order.OrderDeletionException;
import com.eCommerce.eCommerceApp.Exceptions.Order.OrderNotFoundException;
import com.eCommerce.eCommerceApp.Exceptions.Payment.PaymentCreationException;
import com.eCommerce.eCommerceApp.Exceptions.Payment.PaymentDeletionException;
import com.eCommerce.eCommerceApp.Exceptions.Payment.PaymentNotFoundException;
import com.eCommerce.eCommerceApp.Exceptions.Product.InternalServerErrorException;
import com.eCommerce.eCommerceApp.Exceptions.Product.InvalidProductFormatException;
import com.eCommerce.eCommerceApp.Exceptions.Product.ProductNotFoundException;
import com.eCommerce.eCommerceApp.Exceptions.ProductSold.ProductSoldNotFoundException;
import com.eCommerce.eCommerceApp.Exceptions.ProductSold.ProductSoldSaveException;
import com.eCommerce.eCommerceApp.Exceptions.Shipping.ShippingCreationException;
import com.eCommerce.eCommerceApp.Exceptions.Shipping.ShippingDeletionException;
import com.eCommerce.eCommerceApp.Exceptions.Users.UserDeletionException;
import com.eCommerce.eCommerceApp.Exceptions.Users.UserNotFoundException;
import com.eCommerce.eCommerceApp.Exceptions.Users.UserUpdateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserUpdateException.class)
    public ResponseEntity<String> handleUserUpdateException(UserUpdateException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserDeletionException.class)
    public ResponseEntity<String> handleUserDeletionException(UserDeletionException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ShippingCreationException.class)
    public ResponseEntity<String> handleShippingCreationException(ShippingCreationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ShippingDeletionException.class)
    public ResponseEntity<String> handleShippingNotFoundException(ShippingDeletionException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidProductFormatException.class)
    public ResponseEntity<String> handleInvalidProductFormatException(InvalidProductFormatException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<String> handleInternalServerErrorException(InternalServerErrorException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CartCountRetrivalException.class)
    public ResponseEntity<String> handleCartCountRetrievalException(CartCountRetrivalException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductRemovalFromCartException.class)
    public ResponseEntity<String> handleProductRemovalFromCartException(ProductRemovalFromCartException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductsRetrievalByUsernameException.class)
    public ResponseEntity<String> handleProductRetrievalFromUsernameException(ProductsRetrievalByUsernameException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PaymentCreationException.class)
    public ResponseEntity<String> handlePaymentCreationException(PaymentCreationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PaymentDeletionException.class)
    public ResponseEntity<String> handlePaymentDeletionException(PaymentDeletionException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<String> handlePaymentNotFoundException(PaymentNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(OrderCreationException.class)
    public ResponseEntity<String> handleOrderCreationException(OrderCreationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(OrderDeletionException.class)
    public ResponseEntity<String> handleOrderDeletionException(OrderDeletionException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<String> handleOrderNotFoundException(OrderNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductSoldSaveException.class)
    public ResponseEntity<String> handleProductSoldSaveException(ProductSoldSaveException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(ProductSoldNotFoundException.class)
    public ResponseEntity<String> handleProductSoldNotFoundException(ProductSoldNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(TotalPriceCalculationException.class)
    public ResponseEntity<String> handleTotalPriceCalculationException(TotalPriceCalculationException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

}