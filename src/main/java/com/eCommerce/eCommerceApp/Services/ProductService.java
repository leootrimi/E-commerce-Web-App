package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public Product saveProduct(Product product);

    List<Product> getAllProducts();
}
