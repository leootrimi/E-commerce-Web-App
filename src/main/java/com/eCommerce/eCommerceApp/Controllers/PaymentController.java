package com.eCommerce.eCommerceApp.Controllers;

import com.eCommerce.eCommerceApp.Exceptions.Payment.PaymentCreationException;
import com.eCommerce.eCommerceApp.Exceptions.Payment.PaymentDeletionException;
import com.eCommerce.eCommerceApp.Exceptions.Payment.PaymentNotFoundException;
import com.eCommerce.eCommerceApp.Models.Payment;
import com.eCommerce.eCommerceApp.Services.Service.PaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
@Tag(name = "Payment Functions")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.findAllPayments();
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long paymentId) {
        Optional<Payment> payment = paymentService.findPaymentById(paymentId);
        if (payment.isPresent()) {
            return ResponseEntity.ok(payment.get());
        } else {
            throw new PaymentNotFoundException("Payment with id " + paymentId + " not found");
        }
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        try {
            return paymentService.savePayment(payment);
        } catch (Exception e) {
            throw new PaymentCreationException("Failed to create payment");
        }
    }

    @DeleteMapping("/{paymentId}")
    public void deletePayment(@PathVariable Long paymentId) {
        try {
            paymentService.deletePayment(paymentId);
        } catch (Exception e) {
            throw new PaymentDeletionException("Failed to delete payment with id " + paymentId);
        }
    }
}
