package com.eCommerce.eCommerceApp.Controllers;

import com.eCommerce.eCommerceApp.Models.Users;
import com.eCommerce.eCommerceApp.Services.UserServiceImp;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;


    @GetMapping("users")
    public String showdata(){
        return "Hello user";
    }
    @PostMapping("/add")
    public String add(@RequestBody Users us){
        userServiceImp.saveUser(us);
        return "Added successfully";
    }

    @GetMapping("/getall")
    public List<Users> getAllUsers(){ return userServiceImp.getAll(); }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginData, HttpSession session) {
        // Find the customer by username
        String userName = loginData.get("userName");
        String password = loginData.get("password");
        Users user = userServiceImp.findByUsername(userName);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username");
        }

        // Check if the passwords match
        if (user.getPassword() == null || !user.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
        }

        session.setAttribute("userId", user.getId());
        String redirectUrl = "http://localhost:3000/index.html";  // Modify the URL as needed
        return ResponseEntity.ok(redirectUrl);
    }



}
