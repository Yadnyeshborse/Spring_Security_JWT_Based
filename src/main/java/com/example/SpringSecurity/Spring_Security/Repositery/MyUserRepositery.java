package com.example.SpringSecurity.Spring_Security.Repositery;

import com.example.SpringSecurity.Spring_Security.Model.MyUSER;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyUserRepositery extends JpaRepository<MyUSER,Long> {
    Optional<MyUSER> findByusername(String username);
}
