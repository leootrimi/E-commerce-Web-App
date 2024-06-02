package com.eCommerce.eCommerceApp.Controllers;

import com.eCommerce.eCommerceApp.Exceptions.Shipping.ShippingCreationException;
import com.eCommerce.eCommerceApp.Exceptions.Shipping.ShippingDeletionException;
import com.eCommerce.eCommerceApp.Models.Shipping;
import com.eCommerce.eCommerceApp.Services.Service.ShippingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipping")
@Tag(name = "Shipping Functions")

public class ShippingController {

    ShippingService shippingService;
    @Autowired

    public ShippingController(ShippingService shippingService){
        this.shippingService = shippingService;
    }
    @PostMapping
    public ResponseEntity<Shipping> createShipping(@RequestBody Shipping shipping) {
        try {
            Shipping createdShipping = shippingService.saveShipping(shipping);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdShipping);
        } catch (Exception e) {
            throw new ShippingCreationException("Error creating shipping");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShipping(@PathVariable Long id) {
        return shippingService.findById(id)
                .map(shipping -> {
                    shippingService.delete(id);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ShippingDeletionException("Shipping with id " + id + " not found"));
    }
}
