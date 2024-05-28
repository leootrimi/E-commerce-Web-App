package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.Product_Sold;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Product_SoldService {
    public Product_Sold saveProduct(Product_Sold p);
    List<Product_Sold> getAll();
    List<Product_Sold> getAllByusername(String username);

    Double TotalPrice(String username);

}
