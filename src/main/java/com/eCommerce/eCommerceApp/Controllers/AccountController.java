package com.eCommerce.eCommerceApp.Controllers;

import com.eCommerce.eCommerceApp.Exceptions.Users.UserDeletionException;
import com.eCommerce.eCommerceApp.Exceptions.Users.UserNotFoundException;
import com.eCommerce.eCommerceApp.Exceptions.Users.UserUpdateException;
import com.eCommerce.eCommerceApp.Models.Users;
import com.eCommerce.eCommerceApp.Repository.UserRepository;
import com.eCommerce.eCommerceApp.Services.Service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@Tag(name = "Account Functions")
public class AccountController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountController(UserService userService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/{username}")
    public ResponseEntity<Users> getUserById(@PathVariable String username) {
        Users user = userRepository.findByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            throw new UserNotFoundException("User with username " + username + " not found");
        }
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<?> updateUser(@PathVariable String username, @RequestBody Users updatedUser) {
        try {
            Users users = userService.updateUser(username, updatedUser);
            return ResponseEntity.ok().body("User data updated successfully");
        } catch (Exception e) {
            throw new UserUpdateException("Error updating user data for username " + username);
        }
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        try {
            boolean deleted = userService.deleteUser(username);
            if (deleted) {
                return ResponseEntity.ok().body("User deleted successfully");
            } else {
                throw new UserNotFoundException("User with username " + username + " not found");
            }
        } catch (Exception e) {
            throw new UserDeletionException("Error deleting user with username " + username);
        }
    }

    @PutMapping("/update/password/{username}")
    public ResponseEntity<?> changePassword(@RequestBody Map<String, String> passwordChangeRequest, @PathVariable String username) {

        Optional<Users> optionalUser = Optional.ofNullable(userService.findByUsername(username));
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            String oldPassword = passwordChangeRequest.get("oldPassword");
            String storedPassword = user.getPassword();
            boolean passwordMatches = passwordEncoder.matches(oldPassword, storedPassword);
            if (passwordMatches) {
                String newPassword = passwordChangeRequest.get("newPassword");
                user.setPassword(passwordEncoder.encode(newPassword));
                userService.updateUser(username, user);
                return ResponseEntity.ok("Password changed successfully");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Old password is incorrect");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
    }


