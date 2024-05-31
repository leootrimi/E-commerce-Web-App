package com.eCommerce.eCommerceApp.Repository;

import com.eCommerce.eCommerceApp.Models.AccountDelete;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface AccountDeleteRepository extends JpaRepository<AccountDelete, Long> {
        @Modifying
        @Transactional
        public AccountDelete deleteByusername(String username);
        public AccountDelete findByUsername(String username);
}
