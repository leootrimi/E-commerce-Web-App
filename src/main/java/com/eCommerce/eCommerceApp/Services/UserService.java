package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.User;

import java.util.List;
public interface UserService {
    public void saveUser(User user);
    public List<User> getAll();

    User getUserById(int customerId);

    User findByUsername(String username);
    User updateUser(String username, User updateUser);
}
