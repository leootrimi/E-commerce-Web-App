package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.AccountDelete;
import com.eCommerce.eCommerceApp.Repository.AccountDeleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountDeleteServiceImpl implements AccountDeleteService{
    @Autowired
    AccountDeleteRepository accountDeleteRepository;

    @Override
    public AccountDelete createAccountDelete(AccountDelete accountDelete) {
        return accountDeleteRepository.save(accountDelete);
    }

    @Override
    public List<AccountDelete> getAllDeletedAccounts() {
        return accountDeleteRepository.findAll();
    }

    @Override
    public AccountDelete deleteByUsername(String username) {
        return accountDeleteRepository.deleteByusername(username);
    }

    @Override
    public AccountDelete findByUsername(String username) {
        return accountDeleteRepository.findByUsername(username);
    }
}
