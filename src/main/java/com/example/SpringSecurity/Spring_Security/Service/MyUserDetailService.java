package com.example.SpringSecurity.Spring_Security.Service;

import com.example.SpringSecurity.Spring_Security.Model.MyUSER;
import com.example.SpringSecurity.Spring_Security.Repositery.MyUserRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private MyUserRepositery myUserRepositery;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUSER> user=myUserRepositery.findByusername(username);
        System.out.println("usera "+user);
        if (user.isPresent()){
            var userObj=user.get();
            return  User.builder().
                    username(userObj.getUsername())
                    .password(userObj.getPassword()) //123
                    .roles(getRoles(userObj))
                    .build();
        }else {
            throw new UsernameNotFoundException(username);
        }
    }

    private String[] getRoles(MyUSER userObj) {
        if (userObj.getRole()==null){
            return new String[]{"USER"};
        }
        return userObj.getRole().split(",");
    }
}
