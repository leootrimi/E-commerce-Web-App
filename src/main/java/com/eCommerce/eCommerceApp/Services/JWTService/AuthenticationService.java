package com.eCommerce.eCommerceApp.Services.JWTService;

import com.eCommerce.eCommerceApp.Models.AuthenticationResponse;
import com.eCommerce.eCommerceApp.Models.User;
import com.eCommerce.eCommerceApp.Repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;

    private AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse registerUser(User Userrequest){
        User user = new User();
        user.setFirstName(Userrequest.getFirstName());
        user.setLastName(Userrequest.getLastName());
        user.setUsername(Userrequest.getUsername());
        user.setPassword(passwordEncoder.encode(Userrequest.getPassword()));
        user.setEmail(Userrequest.getEmail());
        user.setPhoneNumber(Userrequest.getPhoneNumber());
        user.setZipCode(Userrequest.getZipCode());
        user.setState(Userrequest.getState());
        user.setRole (Userrequest.getRole());

        user = userRepository.save(user);
        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(User userRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userRequest.getUsername(),
                        userRequest.getPassword()
                )
        );
        User user = userRepository.findByUsername(userRequest.getUsername());
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }

    public boolean isUsernameAvailable(String username) {
        return true;
    }
}
