package com.eCommerce.eCommerceApp.Repository;

import com.eCommerce.eCommerceApp.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
