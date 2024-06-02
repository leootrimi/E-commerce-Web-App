package com.eCommerce.eCommerceApp.Service;


import com.eCommerce.eCommerceApp.Models.Product_Sold;
import com.eCommerce.eCommerceApp.Repository.Product_SoldRepository;
import com.eCommerce.eCommerceApp.Services.ServiceImpl.Product_SoldServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Product_SoldServiceImpTest {

    @Mock
    private Product_SoldRepository productSoldRepository;

    @InjectMocks
    private Product_SoldServiceImp productSoldService;

    @Test
    public void saveProductTest() {
        Product_Sold productSold = new Product_Sold();
        productSold.setUsername("testUser");

        when(productSoldRepository.save(any(Product_Sold.class))).thenReturn(productSold);

        Product_Sold savedProductSold = productSoldService.saveProduct(productSold);

        assertThat(savedProductSold).isNotNull();
    }

    @Test
    public void getAllTest() {
        List<Product_Sold> productSoldList = new ArrayList<>();

        when(productSoldRepository.findAll()).thenReturn(productSoldList);

        List<Product_Sold> result = productSoldService.getAll();

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(productSoldList.size());
    }

    @Test
    public void getAllByusernameTest() {
        String username = "testUser";
        List<Product_Sold> productSoldList = new ArrayList<>();

        when(productSoldRepository.getAllByusername(username)).thenReturn(productSoldList);

        List<Product_Sold> result = productSoldService.getAllByusername(username);

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(productSoldList.size());
    }

    @Test
    public void TotalPriceTest() {
        String username = "testUser";
        Double totalPrice = 100.0; // Set the expected total price

        when(productSoldRepository.getTotalPriceByUsername(username)).thenReturn(totalPrice);

        Double result = productSoldService.TotalPrice(username);

        assertThat(result).isEqualTo(totalPrice);
    }


}