package com.eCommerce.eCommerceApp.Service;

import com.eCommerce.eCommerceApp.Models.Shipping;
import com.eCommerce.eCommerceApp.Repository.ShippingRepository;
import com.eCommerce.eCommerceApp.Services.ServiceImpl.ShippingServiceImp;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ShippingServiceImpTest {

    @Mock
    private ShippingRepository shippingRepository;

    @InjectMocks
    private ShippingServiceImp shippingService;

    @Test
    public void saveShippingTest() {
        Shipping shipping = new Shipping();
        // Set up your shipping object

        when(shippingRepository.save(any(Shipping.class))).thenReturn(shipping);

        Shipping savedShipping = shippingService.saveShipping(shipping);

        assertThat(savedShipping).isNotNull();
    }

    @Test
    public void findByIdTest() {
        Long shippingId = 1L;
        Shipping shipping = new Shipping();

        when(shippingRepository.findById(shippingId)).thenReturn(Optional.of(shipping));

        Optional<Shipping> result = shippingService.findById(shippingId);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(shipping);
    }

    @Test
    public void deleteTest() {
        Long shippingId = 1L;

        shippingService.delete(shippingId);

        verify(shippingRepository, times(1)).deleteById(shippingId);
    }

}

