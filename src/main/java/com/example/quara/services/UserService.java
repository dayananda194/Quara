package com.example.quara.services;

import com.example.quara.models.User;
import com.example.quara.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    public User save(User user) {

        if(!userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        return null;
    }
}