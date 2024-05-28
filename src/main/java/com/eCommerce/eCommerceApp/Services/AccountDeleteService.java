package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.AccountDelete;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountDeleteService {
    public AccountDelete createAccountDelete(AccountDelete accountDelete);
    public List<AccountDelete> getAllDeletedAccounts();
    public AccountDelete deleteByUsername(String username);
    public AccountDelete findByUsername(String username);
}
