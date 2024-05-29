package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.Shipping;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ShippingService {
    public Shipping saveShipping(Shipping shipping);
    public Optional<Shipping> findById(Long Id);
    public void delete(Long Id);
}
