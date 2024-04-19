package com.eCommerce.eCommerceApp.Controllers;

import com.eCommerce.eCommerceApp.Models.AuthenticationResponse;
import com.eCommerce.eCommerceApp.Models.User;
import com.eCommerce.eCommerceApp.Services.JWTService.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthenticationController {

    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/get")
    public String hello(){
        return "Hello sir";
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        // Check if the username is available
        if (authenticationService.isUsernameAvailable(user.getUsername())) {
            // If the username is available, proceed with registration
            AuthenticationResponse response = authenticationService.registerUser(user);
            return ResponseEntity.ok(response);
        } else {
            // If the username is not available, return a conflict response with the appropriate message
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username is already taken.");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody User user){
        return ResponseEntity.ok(authenticationService.authenticate(user));
    }

}
