package com.eCommerce.eCommerceApp.Service;


import com.eCommerce.eCommerceApp.Models.AccountDelete;
import com.eCommerce.eCommerceApp.Repository.AccountDeleteRepository;
import com.eCommerce.eCommerceApp.Services.ServiceImpl.AccountDeleteServiceImpl;
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
public class AccountDeleteServiceImplTest {

    @Mock
    private AccountDeleteRepository accountDeleteRepository;

    @InjectMocks
    private AccountDeleteServiceImpl accountDeleteService;

    @Test
    public void createAccountDeleteTest() {
        AccountDelete accountDelete = new AccountDelete();
        accountDelete.setUsername("johndoe");

        when(accountDeleteRepository.save(any(AccountDelete.class))).thenReturn(accountDelete);

        AccountDelete createdAccountDelete = accountDeleteService.createAccountDelete(accountDelete);

        assertThat(createdAccountDelete).isNotNull();
    }
    @Test
    public void getAllDeletedAccountsTest() {
        List<AccountDelete> deletedAccountsList = new ArrayList<>();

        when(accountDeleteRepository.findAll()).thenReturn(deletedAccountsList);

        List<AccountDelete> result = accountDeleteService.getAllDeletedAccounts();

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(deletedAccountsList.size());
    }
    @Test
    public void deleteByUsernameTest() {
        String username = "testUser";
        AccountDelete deletedAccount = new AccountDelete();

        when(accountDeleteRepository.deleteByusername(username)).thenReturn(deletedAccount);

        AccountDelete result = accountDeleteService.deleteByUsername(username);

        assertThat(result).isNotNull();
    }
    @Test
    public void findByUsernameTest() {
        String username = "johndoe";
        AccountDelete accountDelete = new AccountDelete();

        when(accountDeleteRepository.findByUsername(username)).thenReturn(accountDelete);

        AccountDelete result = accountDeleteService.findByUsername(username);

        assertThat(result).isNotNull();
    }


}