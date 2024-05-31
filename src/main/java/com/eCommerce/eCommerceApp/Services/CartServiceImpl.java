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

    public int getCount(String username){
        return cartRepository.countByUsername(username);
    }

    @Override
    public List<Long> getProductIdsByUsername(String username) {
        return cartRepository.findProductIdsByUsername(username);
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
    public void removeProductFromCart(Long productId, String username) {
        Optional<Cart> cartItem = cartRepository.findFirstByProductIdAndUsername(productId, username);
        cartItem.ifPresent(cartRepository::delete);
    }

    @Override
    public void deleteByUsername(String username) {
        try {
            cartRepository.deleteByUsername(username);
        } catch (Exception e){

        }
    }
}




