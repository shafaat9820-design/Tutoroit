package com.tutoroit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutoroit.backend.model.Post;

/**
 * PostRepository
 * Database operations for Post table
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // Abhi extra method ki zarurat nahi
    // findAll() se student/parent/tutor sab posts dekh sakte hain
}
