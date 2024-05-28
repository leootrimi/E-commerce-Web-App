package com.eCommerce.eCommerceApp.Controllers;

import com.eCommerce.eCommerceApp.Models.ContactUs;
import com.eCommerce.eCommerceApp.Services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;
    @PostMapping
    public ContactUs saveContact(@RequestBody ContactUs cs){
        return contactService.save(cs);
    }
    @GetMapping
    public List<ContactUs> getAllContacts(){
        return contactService.getAll();
    }
}

