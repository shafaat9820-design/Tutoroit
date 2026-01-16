package com.tutoroit.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutoroit.backend.model.Post;
import com.tutoroit.backend.model.Role;
import com.tutoroit.backend.model.User;
import com.tutoroit.backend.repository.PostRepository;
import com.tutoroit.backend.repository.UserRepository;

/**
 * PostService
 * - Tutor post create karega
 * - Student / Parent sirf dekh sakte hain
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * CREATE POST (ONLY TUTOR)
     */
    public String createPost(Post post, String tutorEmail) {

        // 1. Tutor email se user nikaalo
        Optional<User> userOpt = userRepository.findByEmail(tutorEmail);

        if (userOpt.isEmpty()) {
            return "Tutor not found";
        }

        User user = userOpt.get();

        // 2. Role check
        if (user.getRole() != Role.TUTOR) {
            return "Only tutor can create post";
        }

        // 3. Tutor details auto-fill
        post.setTutorName(user.getName());
        post.setContactNumber(user.getMobile());
        post.setTutorEmail(user.getEmail());
        // 4. Save post
        postRepository.save(post);

        return "Post created successfully";
    }

    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }


    /**
     * GET ALL POSTS
     * Public API (login ho ya na ho)
     */
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
