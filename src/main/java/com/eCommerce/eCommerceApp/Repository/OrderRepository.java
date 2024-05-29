package com.eCommerce.eCommerceApp.Repository;

import com.eCommerce.eCommerceApp.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Modifying
    @Query("DELETE FROM Order o WHERE o.username = :username")
    void deleteByUsername(String username);
}
