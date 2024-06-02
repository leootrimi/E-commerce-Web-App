package com.eCommerce.eCommerceApp.Controllers;

import com.eCommerce.eCommerceApp.Models.AuthenticationResponse;
import com.eCommerce.eCommerceApp.Models.Users;
import com.eCommerce.eCommerceApp.Services.JWTService.AuthenticationService;
import com.eCommerce.eCommerceApp.Services.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.Optional;

@RestController
@CrossOrigin
@Tag(name = "Authentication Functions")
public class AuthenticationController {

    private AuthenticationService authenticationService;
    @Autowired
    private UserService userService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody Users user){
        Optional<Users> existing = Optional.ofNullable(userService.findByUsername(user.getUsername()));
        if (existing.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new AuthenticationResponse("User with username " + user.getUsername() + " already exists"));
        }
        return ResponseEntity.ok(authenticationService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody Users user){
        return ResponseEntity.ok(authenticationService.authenticate(user));
    }

}
