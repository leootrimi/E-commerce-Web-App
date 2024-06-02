package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.Product_Sold;
import com.eCommerce.eCommerceApp.Repository.Product_SoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Product_SoldServiceImp implements Product_SoldService{

    @Autowired
    Product_SoldRepository productSoldRepository;

    public Product_Sold saveProduct(Product_Sold p){ return productSoldRepository.save(p);}

    @Override
    public List<Product_Sold> getAll() {
        return productSoldRepository.findAll();
    }

    @Override
    public List<Product_Sold> getAllByusername(String username) {
        return productSoldRepository.getAllByusername(username);
    }

    @Override
    public Double TotalPrice(String username) {
        return productSoldRepository.getTotalPriceByUsername(username);
    }
}
