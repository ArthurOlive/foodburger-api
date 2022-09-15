package com.api.foodburg.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.foodburg.models.UserSystem;
import com.api.foodburg.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserSystem getByUsername(String login) {
        return userRepository.findByUsername(login);
    }

    @Transactional
    public UserSystem create(UserSystem user) {
        return userRepository.save(user);
    }
}