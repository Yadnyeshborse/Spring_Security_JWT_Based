package com.example.SpringSecurity.Spring_Security.Controller;

import com.example.SpringSecurity.Spring_Security.Model.MyUSER;
import com.example.SpringSecurity.Spring_Security.Repositery.MyUserRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private MyUserRepositery myUserRepositery;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register/user")
    public MyUSER createUser(@RequestBody MyUSER user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return myUserRepositery.save(user);
    }
    //"userName":"admin",
    //    "password":"admin",
}
