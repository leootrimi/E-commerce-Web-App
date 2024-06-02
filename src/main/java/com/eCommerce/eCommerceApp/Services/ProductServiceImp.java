package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.Cart;
import com.eCommerce.eCommerceApp.Models.Product;
import com.eCommerce.eCommerceApp.Repository.CartRepository;
import com.eCommerce.eCommerceApp.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCart(Cart cartEntry) {
        cartRepository.save(cartEntry);
    }

    @Override
    public List<Product> getProductByCategory(Long categoryID) {
        return productRepository.findByCategoryId(categoryID);
    }
}
