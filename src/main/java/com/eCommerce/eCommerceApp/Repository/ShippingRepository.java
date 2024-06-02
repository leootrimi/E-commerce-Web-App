package com.eCommerce.eCommerceApp.Repository;

import com.eCommerce.eCommerceApp.Models.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Long> {

}
