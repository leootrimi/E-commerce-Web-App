package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.Users;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserService {
    public void saveUser(Users user);
    public List<Users> getAll();

    Users getUserById(int customerId);

    Users findByUsername(String username);
    Users updateUser(String username, Users updateUser);
    boolean deleteUser(String username);
    
}
