package com.example.SpringSecurity.Spring_Security.Controller;

import com.example.SpringSecurity.Spring_Security.Service.MyUserDetailService;
import com.example.SpringSecurity.Spring_Security.webToken.JwtService;
import com.example.SpringSecurity.Spring_Security.webToken.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private MyUserDetailService myUserDetailService;

    @GetMapping("/home")
    public String getHome(){
        return "home";
    }

    @GetMapping("/admin/home")
    public String handelAdmin(){
        return "admin_home";
    }

    @GetMapping("/user/home")
    public String handelUser(){
        return "user_home";
    }









}
