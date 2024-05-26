package com.eCommerce.eCommerceApp.Controllers;

import com.eCommerce.eCommerceApp.Models.Cart;
import com.eCommerce.eCommerceApp.Models.Product;
import com.eCommerce.eCommerceApp.Models.Users;
import com.eCommerce.eCommerceApp.Repository.ProductRepository;
import com.eCommerce.eCommerceApp.Repository.UserRepository;
import com.eCommerce.eCommerceApp.Services.ProductService;
import com.eCommerce.eCommerceApp.Services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
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
            return ResponseEntity.notFound().build();
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
            return ResponseEntity.badRequest().body("Invalid productId format");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getproductsCategory/{categoryID}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable Long categoryID) {
        List<Product> products = productService.getProductByCategory(categoryID);
        return ResponseEntity.ok(products);
    }


}

