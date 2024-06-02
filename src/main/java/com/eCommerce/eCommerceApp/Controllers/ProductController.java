package com.eCommerce.eCommerceApp.Controllers;

import com.eCommerce.eCommerceApp.Exceptions.Product.InternalServerErrorException;
import com.eCommerce.eCommerceApp.Exceptions.Product.InvalidProductFormatException;
import com.eCommerce.eCommerceApp.Exceptions.Product.ProductNotFoundException;
import com.eCommerce.eCommerceApp.Models.Cart;
import com.eCommerce.eCommerceApp.Models.Product;
import com.eCommerce.eCommerceApp.Repository.ProductRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.eCommerce.eCommerceApp.Services.Service.ProductService;
import com.eCommerce.eCommerceApp.Services.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
@Tag(name = "Product Functions")

public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;
    private final UserService userService;

    @Autowired

    public ProductController(ProductService productService, ProductRepository productRepository, UserService userService) {
        this.productService = productService;
        this.productRepository = productRepository;
        this.userService = userService;
    }

    @GetMapping("/getproducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
    }

    @PostMapping("/products/add")
    public ResponseEntity<String> addToCart(@RequestBody Map<String, Object> requestData) {
        try {
            String username = (String) requestData.get("username");
            Long productId = Long.parseLong(String.valueOf(requestData.get("productId")));


            System.out.println(username);

            Cart addcart = new Cart(productId, username);

            productService.saveCart(addcart);
            return ResponseEntity.ok("Product added to cart successfully.");
        } catch (NumberFormatException e) {
            throw new InvalidProductFormatException("Invalid productId format");
        } catch (Exception e) {
            throw new InternalServerErrorException("An unexpected error occurred");
        }
    }

    @GetMapping("/getproductsCategory/{categoryID}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable Long categoryID) {
        List<Product> products = productService.getProductByCategory(categoryID);
        return ResponseEntity.ok(products);
    }


}

