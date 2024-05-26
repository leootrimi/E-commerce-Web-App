package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.*;

import java.util.List;

public interface CartService {
    // Merr karrocen per nje perdorues
    Cart getCartByUser(Users user);

    // Shton nje produkt ne karroce
    void addToCart(Users user, Product product, int quantity);

    // Heq nje produkt nga karroca
    void removeFromCart(Users user, Product product);

    // Pastron karrocen
    void clearCart(Users user);

    // Merr listen e artikujve ne karrocen e nje perdoruesi
    List<CartItem> getCartItems(Users user);
}
