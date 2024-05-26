package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.*;

import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {

    // Simulimi i nje baze te dhenash lokale per ruajtjen e karroces
    private List<Cart> carts = new ArrayList<>();

    @Override
    public Cart getCartByUser(Users user) {
        // Kerko karrocen per perdoruesin e dhene
        for (Cart cart : carts) {
            if (cart.getUser().equals(user)) {
                return cart;
            }
        }
        // Nese karroca nuk gjendet, kthe null
        return null;
    }



    @Override
    public void addToCart(Users user, Product product, int quantity) {
        // Merr karrocen per perdoruesin nese ekziston, ose krijoni nje karroce te re
        Cart cart = getCartByUser(user);
        if (cart == null) {
            cart = new Cart(user);
            carts.add(cart);
        }

        // Kerko nese produkti eshte ne karroce, nese po, shto sasine
        boolean found = false;
        for (CartItem item : cart.getCartItems()) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(item.getQuantity() + quantity);
                found = true;
                break;
            }
        }
        // Nese produkti nuk gjendet ne karroce, krijo nje artikull te ri ne karroce
        if (!found) {
            CartItem newItem = new CartItem(cart, product, quantity);
            cart.getCartItems().add(newItem);
        }
    }

    @Override
    public void removeFromCart(Users user, Product product) {
        // Merr karrocen per perdoruesin
        Cart cart = getCartByUser(user);
        if (cart != null) {
            // Heq produktin nga karroca nese ekziston
            cart.getCartItems().removeIf(item -> item.getProduct().equals(product));
        }
    }

    @Override
    public void clearCart(Users user) {
        // Merr karrocen per perdoruesin dhe fshij te gjitha produktet
        Cart cart = getCartByUser(user);
        if (cart != null) {
            cart.getCartItems().clear();
        }
    }

    @Override
    public List<CartItem> getCartItems(Users user) {
        // Kthe listen e artikujve ne karrocen e nje perdoruesi nese ekziston, ose null nese nuk ka
        Cart cart = getCartByUser(user);
        return cart != null ? cart.getCartItems() : null;
    }
}
