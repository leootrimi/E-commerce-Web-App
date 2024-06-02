package com.eCommerce.eCommerceApp.Repository;

import com.eCommerce.eCommerceApp.Models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
