package com.vite.Controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.vite.Model.User;

import com.vite.Service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity <User> createUser(@RequestBody @Valid User user){ //when you return with a response entity, you can return response with http status.
    
        User createUser = userService.createUser(user);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity <User> getUserById(@PathVariable Long id) throws Exception{
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
        
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) throws Exception{
        User updatedUser = userService.updateUser(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

       
    

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity <String> deleteUser(@PathVariable Long id) throws Exception{
         userService.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.ACCEPTED);
    }
    
}
