package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.*;
import com.eCommerce.eCommerceApp.Repository.CartRepository;
import com.eCommerce.eCommerceApp.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

@Autowired
    CartRepository cartRepository;
@Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getCartByUser(String username) {
        return cartRepository.findProductsByUsername(username);
    }

<<<<<<< Updated upstream
<<<<<<< Updated upstream
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
=======
    public int getCount(String username){
        return cartRepository.countByUsername(username);
>>>>>>> Stashed changes
=======
    public int getCount(String username){
        return cartRepository.countByUsername(username);
>>>>>>> Stashed changes
    }

    @Override
    public List<Long> getProductIdsByUsername(String username) {
        return cartRepository.findProductIdsByUsername(username);
<<<<<<< Updated upstream
    }

    @Override
    public List<Product> getDataFromProductIds(List<Long> productIds) {
        List<Product> products = new ArrayList<>();
        for (Long productId : productIds) {
            Optional<Product> optionalProduct = productRepository.findById(productId);
            optionalProduct.ifPresent(products::add);
        }
        return products;
    }

    @Override
    public Double getTotalPriceofCart(List<Product> products) {
        if (products == null || products.isEmpty()) {
            return 0.0;
        }
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    @Override
=======
    }

    @Override
    public List<Product> getDataFromProductIds(List<Long> productIds) {
        List<Product> products = new ArrayList<>();
        for (Long productId : productIds) {
            Optional<Product> optionalProduct = productRepository.findById(productId);
            optionalProduct.ifPresent(products::add);
        }
        return products;
    }

    @Override
    public Double getTotalPriceofCart(List<Product> products) {
        if (products == null || products.isEmpty()) {
            return 0.0;
        }
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    @Override
>>>>>>> Stashed changes
    public void removeProductFromCart(Long productId, String username) {
        Optional<Cart> cartItem = cartRepository.findFirstByProductIdAndUsername(productId, username);
        cartItem.ifPresent(cartRepository::delete);
    }
}




