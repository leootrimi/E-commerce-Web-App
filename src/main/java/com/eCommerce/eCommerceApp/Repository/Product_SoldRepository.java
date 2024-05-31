package com.eCommerce.eCommerceApp.Repository;

import com.eCommerce.eCommerceApp.Models.Product_Sold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Product_SoldRepository extends JpaRepository<Product_Sold, Long> {
    List<Product_Sold> getAllByusername(String username);

    @Query("SELECT SUM(o.price) FROM Order o WHERE o.username = :username")
    Double getTotalPriceByUsername(@Param("username") String username);
}
