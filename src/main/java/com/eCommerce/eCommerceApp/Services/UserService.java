package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.User;

import java.util.List;
public interface UserService {
    public void saveUser(User user);
    public List<User> getAll();

    User getUserById(int customerId);

<<<<<<< HEAD
    User findByUsername(String username);
    User updateUser(String username, User updateUser);
=======
    Users findByUsername(String username);
    Users updateUser(String username, Users updateUser);
    boolean deleteUser(String username);
    
>>>>>>> 55407030992756faf8cd64dfd4216b65c0f5c3b4
}
