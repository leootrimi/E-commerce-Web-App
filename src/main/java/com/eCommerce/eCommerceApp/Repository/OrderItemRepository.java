package com.eCommerce.eCommerceApp.Repository;

import com.eCommerce.eCommerceApp.Models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
