package com.eCommerce.eCommerceApp.Controllers;

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
        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    @DeleteMapping("/{paymentId}")
    public void deletePayment(@PathVariable Long paymentId) {
        paymentService.deletePayment(paymentId);
    }
}
