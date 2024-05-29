package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.Shipping;
import com.eCommerce.eCommerceApp.Repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ShippingServiceImp implements ShippingService{
    @Autowired
    ShippingRepository shippingRepository;
    @Override
    public Shipping saveShipping(Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    @Override
    public Optional<Shipping> findById(Long Id) {
        return shippingRepository.findById(Id);
    }

    @Override
    public void delete(Long Id) {
        shippingRepository.deleteById(Id);
    }
}
