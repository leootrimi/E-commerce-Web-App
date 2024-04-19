package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.User;
import com.eCommerce.eCommerceApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService, UserDetailsService {
    @Autowired
    UserRepository userRepository;


    @Override
    public void saveUser(User user) {
        // Save the user using UserRepository
        userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User updateUser(String username, User updateUser) {

        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            if (updateUser.getFirstName() != null){
                existingUser.setFirstName(updateUser.getFirstName());}
            else {existingUser.setFirstName(existingUser.getFirstName());}

            if (updateUser.getLastName() != null){
                existingUser.setLastName(updateUser.getLastName());}
            else {existingUser.setLastName(existingUser.getLastName());}

            if (updateUser.getUsername() != null){
                existingUser.setUsername(updateUser.getUsername());}
            else {existingUser.setUsername(existingUser.getUsername());}

            if (updateUser.getEmail() != null){
                existingUser.setEmail(updateUser.getEmail());}
            else {existingUser.setEmail(existingUser.getEmail());}


            if (updateUser.getPhoneNumber() != null){
                existingUser.setPhoneNumber(updateUser.getPhoneNumber());}
            else {existingUser.setPhoneNumber(existingUser.getPhoneNumber());}


            if (updateUser.getZipCode() != null){
                existingUser.setZipCode(updateUser.getZipCode());}
            else {existingUser.setZipCode(existingUser.getZipCode());}


            if (updateUser.getState() != null){
                existingUser.setState(updateUser.getState());}
            else {existingUser.setState(existingUser.getState());}
            return userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public User deleteUser(String username) {
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            userRepository.delete(existingUser);
            return existingUser;
        }
        return null;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}