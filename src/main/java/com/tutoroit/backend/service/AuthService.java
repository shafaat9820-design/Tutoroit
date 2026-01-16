package com.tutoroit.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutoroit.backend.dto.LoginRequest;
import com.tutoroit.backend.dto.RegisterRequest;
import com.tutoroit.backend.model.User;
import com.tutoroit.backend.repository.UserRepository;

/**
 * AuthService
 * Register + Login ka pura logic yahin hoga
 */
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    /**
     * REGISTER LOGIC
     */
    /**
     * REGISTER LOGIC
     */
    public void register(RegisterRequest request) {

        // 1. Email already exist check
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        // 2. New user create
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        // ✅ VERY IMPORTANT FIX (null → empty string)
        user.setMobile(
                request.getMobile() != null ? request.getMobile() : ""
        );

        user.setRole(request.getRole());

        // 3. Save in DB
        userRepository.save(user);
    }

    /**
     * LOGIN LOGIC
     */
    /**
     * LOGIN LOGIC
     */
    public User login(LoginRequest request) {

        // 1. Email check
        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
        if (userOpt.isEmpty()) {
            throw new RuntimeException("Invalid email or password");
        }

        User user = userOpt.get();

        // 2. Password check
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        // 3. SUCCESS → return full user object
        return user;
    }
}