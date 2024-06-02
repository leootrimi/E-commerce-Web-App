package com.eCommerce.eCommerceApp.Services.Service;

import com.eCommerce.eCommerceApp.Models.Payment;
import com.eCommerce.eCommerceApp.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public interface PaymentService {

    public List<Payment> findAllPayments();

    public Optional<Payment> findPaymentById(Long paymentId);
    public Payment savePayment(Payment payment);

    public void deletePayment(Long paymentId);
}
