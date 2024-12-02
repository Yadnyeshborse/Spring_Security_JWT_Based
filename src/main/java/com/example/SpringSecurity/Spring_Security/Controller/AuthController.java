package com.example.SpringSecurity.Spring_Security.Controller;

import com.example.SpringSecurity.Spring_Security.Service.MyUserDetailService;
import com.example.SpringSecurity.Spring_Security.webToken.JwtService;
import com.example.SpringSecurity.Spring_Security.webToken.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private MyUserDetailService myUserDetailService;

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody LoginForm loginForm) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginForm.username(), loginForm.password())
            );

            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(myUserDetailService.loadUserByUsername(loginForm.username()));
            } else {
                throw new UsernameNotFoundException("Invalid credentials");
            }
        } catch (Exception e) {
            throw new RuntimeException("Authentication failed", e);
        }
    }   //vvimp use restcontroller than we will get key in pstman
}
