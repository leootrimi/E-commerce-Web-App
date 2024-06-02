package com.eCommerce.eCommerceApp.Repository;

import com.eCommerce.eCommerceApp.Models.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactUs, Long> {
}
