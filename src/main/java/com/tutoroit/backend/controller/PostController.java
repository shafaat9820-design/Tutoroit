// package com.tutoroit.backend.controller;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;
// import com.tutoroit.backend.model.Post;
// import com.tutoroit.backend.service.PostService;

// @RestController
// @RequestMapping("/api/posts")
// @CrossOrigin(origins = "http://localhost:5173")
// public class PostController {

//     @Autowired
//     private PostService postService;

//     // ✅ CREATE POST
//     @PostMapping("/create")
//     @CrossOrigin(origins = "http://localhost:5173")
//     public String createPost(
//             @RequestBody Post post,
//             @RequestParam String tutorEmail) {

//         return postService.createPost(post, tutorEmail);
//     }

//     // ✅ GET ALL POSTS (IMPORTANT FIX)
//     @GetMapping
//     @CrossOrigin(origins = "http://localhost:5173")
//     public List<Post> getAllPosts() {
//         return postService.getAllPosts();
//     }
//     @DeleteMapping("/delete/{id}")
//     @CrossOrigin(origins = "http://localhost:5173")
//     public String deletePost(@PathVariable Long id) {
//         postService.deletePostById(id);


package com.tutoroit.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tutoroit.backend.model.Post;
import com.tutoroit.backend.service.PostService;

@RestController
@RequestMapping("/api/posts")

// ✅ FIX 1: Allow deployed + local frontend (CORS)
@CrossOrigin(
    origins = {
        "http://localhost:5173",
        "https://tutoroit-frontend.vercel.app"
    },
    allowedHeaders = "*",
    methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS }
)
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * ✅ CREATE POST (Tutor only)
     * IMPORTANT:
     * - JSON body only
     * - No RequestParam (preflight safe)
     */
    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post) {

        postService.createPost(post);
        return ResponseEntity.ok("Post created successfully");
    }

    /**
     * ✅ GET ALL POSTS
     */
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    /**
     * ✅ DELETE POST
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        postService.deletePostById(id);
        return ResponseEntity.ok("Post deleted");
    }
}

//         return "Post deleted";
//     }

// }
