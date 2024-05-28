package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.ContactUs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {
    public ContactUs save(ContactUs c);
    public List<ContactUs> getAll();
}
