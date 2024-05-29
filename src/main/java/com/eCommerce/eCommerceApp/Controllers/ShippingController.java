package com.eCommerce.eCommerceApp.Controllers;

import com.eCommerce.eCommerceApp.Models.Shipping;
import com.eCommerce.eCommerceApp.Services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    ShippingService shippingService;
    @Autowired

    public ShippingController(ShippingService shippingService){
        this.shippingService = shippingService;
    }
    @PostMapping
    public Shipping createShipping(@RequestBody Shipping shipping) {
        return shippingService.saveShipping(shipping);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShipping(@PathVariable Long id) {
        return shippingService.findById(id)
                .map(shipping -> {
                    shippingService.delete(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }



}
