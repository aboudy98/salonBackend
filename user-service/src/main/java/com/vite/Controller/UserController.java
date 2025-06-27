package com.vite.Controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vite.Model.User;

@RestController
public class UserController {

    @GetMapping("/api/users")
    public User getUser(){
        User user = new User();
        user.setFullName("John Doe");
        user.setEmail("Mazloum@gmail.com");
        user.setPhone("123-456-7890");
        user.setRole("Admin");
        
        return user;
    }
    
}
