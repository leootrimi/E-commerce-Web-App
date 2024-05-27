package com.eCommerce.eCommerceApp.Repository;

import com.eCommerce.eCommerceApp.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
