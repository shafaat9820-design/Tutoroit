package com.tutoroit.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutoroit.backend.model.User;

/**
 * UserRepository
 * Database operations for User table
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Login ke time email se user nikalne ke liye
     */
    Optional<User> findByEmail(String email);
}
