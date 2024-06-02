package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    List<Product> getCartByUser(String username);

    int getCount(String username);

    List<Long> getProductIdsByUsername(String username);

    List<Product> getDataFromProductIds(List<Long> productIds);

    Double getTotalPriceofCart(List<Product> products);

    void removeProductFromCart(Long id, String username);

    void deleteByUsername(String username);

}
