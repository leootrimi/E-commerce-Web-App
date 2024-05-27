package com.eCommerce.eCommerceApp.Repository;

import com.eCommerce.eCommerceApp.Models.Cart;
import com.eCommerce.eCommerceApp.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query(value = "SELECT * FROM cart WHERE username = :username", nativeQuery = true)
    List<Cart> findByUsername(@Param("username") String username);

    @Query(value = "SELECT COUNT(*) FROM cart WHERE username = :username", nativeQuery = true)
    int countByUsername(@Param("username") String username);

    @Query(value = "SELECT p.* FROM product p INNER JOIN cart c ON p.id = c.product_id WHERE c.username = :username", nativeQuery = true)
    List<Product> findProductsByUsername(@Param("username") String username);

    @Query("SELECT productId FROM Cart WHERE username = :username")
    List<Long> findProductIdsByUsername(String username);

    Optional<Cart> findFirstByProductIdAndUsername(Long productId, String username);

}
