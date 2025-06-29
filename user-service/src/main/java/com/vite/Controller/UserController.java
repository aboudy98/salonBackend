package com.vite.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.vite.Exception.UserException;
import com.vite.Model.User;
import com.vite.Repository.UserRepository;

import jakarta.validation.Valid;



;


@RestController

public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/api/users")
    public User createUser(@RequestBody @Valid User user){
        return userRepository.save(user);
    }

    @GetMapping("/api/users")
    public List <User> getUsers(){
       
        return userRepository.findAll();
    }

    @GetMapping("/api/users/{id}")
    public User getUserById(@PathVariable Long id) throws Exception{
        Optional<User> user = userRepository.findById(id);
        if (user != null) {
            return user.get();
            
        }
        throw new UserException("User not found !");
    }

    @PutMapping("/api/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) throws Exception{
        User oldUser = userRepository.findById(id).orElseThrow(
            () -> new UserException("User not found with id: " + id));
            if(user.getFullName() != null){
                oldUser.setFullName(user.getFullName());
            }
            if (user.getEmail() != null) {
                oldUser.setEmail(user.getEmail());
                
            }
            if (user.getPhone() != null) {
                oldUser.setPhone(user.getPhone());
                
            }
            if (user.getRole() != null) {
                oldUser.setRole(user.getRole());
                
            }

        return userRepository.save(oldUser);
    }

    @DeleteMapping("/api/users/{id}")
    public String deleteUser(@PathVariable Long id) throws Exception{
        User user = userRepository.findById(id).orElseThrow(
            () -> new UserException("User not found with id: " + id));
        userRepository.delete(user);
        return "User deleted successfully with id: " + id;
    }
    
}
