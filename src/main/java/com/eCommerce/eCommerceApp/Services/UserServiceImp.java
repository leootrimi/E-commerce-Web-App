package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.Users;
import com.eCommerce.eCommerceApp.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService, UserDetailsService {
    @Autowired
    UserRepository userRepository;


    @Override
    public void saveUser(Users user) {
        userRepository.save(user);
    }

    @Override
    public List<Users> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public Optional<Users> findByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    @Override
    public Users updateUser(String username, Users updateUser) {

        Users existingUser = userRepository.findByUsername(username);
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
    @Modifying
    @Transactional
    @Override
public boolean deleteUser(String username) {
        boolean result = false;
        Users existingUser = userRepository.findByUsername(username);
    if (existingUser != null) {
        userRepository.delete(existingUser);
        result = true;
    }
        return result;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
