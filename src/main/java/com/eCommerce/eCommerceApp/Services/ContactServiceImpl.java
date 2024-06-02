package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.ContactUs;
import com.eCommerce.eCommerceApp.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    private ContactRepository contactRepository;
    @Override
    public ContactUs save(ContactUs c) {
        return contactRepository.save(c);
    }

    @Override
    public List<ContactUs> getAll() {
        return contactRepository.findAll();
    }
}
