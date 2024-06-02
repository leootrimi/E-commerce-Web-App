package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public void saveUser(Users user);
    public List<Users> getAll();

    Users getUserById(int customerId);

    Optional<Users> findByUsername(String username);
    Users updateUser(String username, Users updateUser);
    @Modifying
    @Transactional
    boolean deleteUser(String username);
    
}
