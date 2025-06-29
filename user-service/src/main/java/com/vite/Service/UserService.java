package com.vite.Service;

import java.util.List;

import com.vite.Exception.UserException;
import com.vite.Model.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id) throws UserException ;
    User updateUser(Long id, User user) throws UserException;
    void deleteUser(Long id) throws UserException;
    List<User>getAllUsers();
    
}
