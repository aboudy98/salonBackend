package com.vite.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vite.Exception.UserException;
import com.vite.Model.User;
import com.vite.Repository.UserRepository;
import com.vite.Service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserException {
        Optional<User> user = userRepository.findById(id);
        if (user != null) {
            return user.get();

        }
        throw new UserException("User not found !");
    }

    @Override
    public User updateUser(Long id, User user) throws UserException {
        User oldUser = userRepository.findById(id).orElseThrow(
                () -> new UserException("User not found with id: " + id));
        if (user.getFullName() != null) {
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

    @Override
    public void deleteUser(Long id) throws UserException {
        User user = userRepository.findById(id).orElseThrow(
            () -> new UserException("User not found with id: " + id));
        userRepository.delete(user);
        
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
