package com.eCommerce.eCommerceApp.Controllers;

import com.eCommerce.eCommerceApp.Exceptions.Cart.CartCountRetrivalException;
import com.eCommerce.eCommerceApp.Exceptions.Cart.ProductRemovalFromCartException;
import com.eCommerce.eCommerceApp.Exceptions.Cart.ProductsRetrievalByUsernameException;
import com.eCommerce.eCommerceApp.Exceptions.Cart.TotalPriceCalculationException;
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
            System.out.println("Times found " + count);
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            throw new CartCountRetrivalException("An error occurred while getting cart count for username: " + username);
        }
    }

    @GetMapping("/findByUsername/{username}")
    public ResponseEntity<List<Product>> getProductsByUsername(@PathVariable String username) {
        try {
            List<Long> productIds = cartServiceImpl.getProductIdsByUsername(username);
            if (productIds.isEmpty()) {
                throw new ProductsRetrievalByUsernameException("No products found for username: " + username);
            }
            List<Product> products = cartServiceImpl.getDataFromProductIds(productIds);
            return ResponseEntity.ok(products);
        } catch (ProductsRetrievalByUsernameException e) {
            throw e;
        } catch (Exception e) {
            throw new ProductsRetrievalByUsernameException("An error occurred while getting products for username: " + username);
        }
    }

    @DeleteMapping("/removeCart/{id}/{username}")
    public ResponseEntity<String> removeProductFromCart(@PathVariable Long id, @PathVariable String username) {
        try {
            cartServiceImpl.removeProductFromCart(id, username);
            return ResponseEntity.ok("Product removed from cart successfully");
        } catch (Exception e) {
            throw new ProductRemovalFromCartException("Failed to remove product from cart for username: " + username);
        }
    }

    @GetMapping("/totalPrice/{username}")
    public ResponseEntity<Double> totalPrice(@PathVariable String username) {
        try {
            List<Long> productIDs = cartServiceImpl.getProductIdsByUsername(username);
            if (productIDs.isEmpty()) {
                throw new TotalPriceCalculationException("No products found for username: " + username);
            }
            List<Product> products = cartServiceImpl.getDataFromProductIds(productIDs);
            double total = cartServiceImpl.getTotalPriceofCart(products);
            return ResponseEntity.ok(total);
        } catch (TotalPriceCalculationException e) {
            throw e;
        } catch (Exception e) {
            throw new TotalPriceCalculationException("An error occurred while calculating total price for username: " + username);
        }
    }

}
