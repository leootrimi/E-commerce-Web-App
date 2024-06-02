package com.eCommerce.eCommerceApp.Controllers;

import com.eCommerce.eCommerceApp.Models.Product;
import com.eCommerce.eCommerceApp.Services.ServiceImpl.CartServiceImpl;
import com.eCommerce.eCommerceApp.Services.ServiceImpl.UserServiceImp;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/carts")
@Tag(name = "Cart Functions")
public class CartController {
    @Autowired
    private CartServiceImpl cartServiceImpl;

    @Autowired
    private UserServiceImp userServiceImp;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/user/{username}/count")
    public ResponseEntity<Integer> getCartCountByUsername(@PathVariable String username) {
        try {
            int count = cartServiceImpl.getCount(username);

            System.out.println("Times found "  + count);
            return ResponseEntity.ok(count);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/findByUsername/{username}")
    public ResponseEntity<List<Product>> getProductsByUsername(@PathVariable String username) {
        try {
            List<Long> productsId = cartServiceImpl.getProductIdsByUsername(username);
            List<Product> products = cartServiceImpl.getDataFromProductIds(productsId);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/removeCart/{id}/{username}")
    public ResponseEntity<String> removeProductFromCart(@PathVariable Long id, @PathVariable String username) {
        try {
            cartServiceImpl.removeProductFromCart(id, username);
            return ResponseEntity.ok("Product removed from cart successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to remove product from cart");
        }
    }

    @GetMapping("/totalPrice/{username}")
    public ResponseEntity<Double> totalPrice(@PathVariable String username){
        try {
            List<Long> productIDs = cartServiceImpl.getProductIdsByUsername(username);
            List<Product> products = cartServiceImpl.getDataFromProductIds(productIDs);
            double total = cartServiceImpl.getTotalPriceofCart(products);
            return ResponseEntity.ok(total);
        } catch (Exception e){
            return ResponseEntity.status(404).build();
        }
    }





}
