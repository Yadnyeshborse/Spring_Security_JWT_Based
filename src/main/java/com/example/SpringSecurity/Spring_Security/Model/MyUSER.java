package com.example.SpringSecurity.Spring_Security.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Spring_Security_Tutorial_Table")
public class MyUSER {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username")
    private String username;
    private String password;
    private String role;  //Admin ,USER
}
