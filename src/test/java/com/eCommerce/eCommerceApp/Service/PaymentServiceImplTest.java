package com.eCommerce.eCommerceApp.Service;

import com.eCommerce.eCommerceApp.Models.Payment;
import com.eCommerce.eCommerceApp.Repository.PaymentRepository;
import com.eCommerce.eCommerceApp.Services.ServiceImpl.PaymentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceImplTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Test
    public void findAllPaymentsTest() {
        List<Payment> paymentList = new ArrayList<>();

        when(paymentRepository.findAll()).thenReturn(paymentList);

        List<Payment> result = paymentService.findAllPayments();

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(paymentList.size());
    }

    @Test
    public void findPaymentByIdTest() {
        Long paymentId = 1L;
        Date date = new Date();
        BigDecimal total = BigDecimal.valueOf(213.22);
        Payment payment = new Payment(1L,"CreditCard",date,total);

        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(payment));

        Optional<Payment> result = paymentService.findPaymentById(paymentId);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(payment);
    }

    @Test
    public void savePaymentTest() {
        Date date = new Date();
        BigDecimal total = BigDecimal.valueOf(213.22);
        Payment payment = new Payment(1L,"CreditCard",date,total);

        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        Payment savedPayment = paymentService.savePayment(payment);

        assertThat(savedPayment).isNotNull();
    }

    @Test
    public void deletePaymentTest() {
        Long paymentId = 1L;

        paymentService.deletePayment(paymentId);

        verify(paymentRepository, times(1)).deleteById(paymentId);
    }

}