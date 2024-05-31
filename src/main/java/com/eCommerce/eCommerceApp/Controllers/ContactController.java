package com.eCommerce.eCommerceApp.Controllers;

import com.eCommerce.eCommerceApp.Models.ContactUs;
import com.eCommerce.eCommerceApp.Services.ContactService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
@Tag(name = "Contact Functions")
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

