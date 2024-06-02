package com.eCommerce.eCommerceApp.Service;

import com.eCommerce.eCommerceApp.Models.ContactUs;
import com.eCommerce.eCommerceApp.Repository.ContactRepository;
import com.eCommerce.eCommerceApp.Services.ServiceImpl.ContactServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContactServiceImplTest {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactServiceImpl contactService;

    @Test
    public void saveTest() {
        ContactUs contactUs = new ContactUs();

        when(contactRepository.save(any(ContactUs.class))).thenReturn(contactUs);

        ContactUs savedContactUs = contactService.save(contactUs);

        assertThat(savedContactUs).isNotNull();
    }
    @Test
    public void getAllTest() {
        List<ContactUs> contactUsList = new ArrayList<>();

        when(contactRepository.findAll()).thenReturn(contactUsList);

        List<ContactUs> result = contactService.getAll();

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(contactUsList.size());
    }

}