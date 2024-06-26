package com.eCommerce.eCommerceApp.Controllers;

import com.eCommerce.eCommerceApp.Models.Product_Sold;
import com.eCommerce.eCommerceApp.Services.Service.Product_SoldService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sold")
@Tag(name = "Product Sold Functions")
public class Product_SoldController {
    @Autowired
    private Product_SoldService productSoldService;


    @PostMapping
    public Product_Sold save(@RequestBody Product_Sold p){
        return productSoldService.saveProduct(p);
    }

    @GetMapping
    public List<Product_Sold> products(){
        return productSoldService.getAll();
    }

    @GetMapping("/product/{username}")
    public List<Product_Sold> getAllbyUsername(@PathVariable String username){
        return productSoldService.getAllByusername(username);
    }

    @GetMapping("/price/{username}")
    public Double TotalPrice(@PathVariable String username){
        return productSoldService.TotalPrice(username);
    }
}
