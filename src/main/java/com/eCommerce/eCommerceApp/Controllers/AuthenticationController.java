package com.eCommerce.eCommerceApp.Controllers;

import com.eCommerce.eCommerceApp.Models.AuthenticationResponse;
import com.eCommerce.eCommerceApp.Models.Users;
import com.eCommerce.eCommerceApp.Services.JWTService.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

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
    public ResponseEntity<AuthenticationResponse> register(@RequestBody Users user){

        return ResponseEntity.ok(authenticationService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody Users user){
        return ResponseEntity.ok(authenticationService.authenticate(user));
    }

}
