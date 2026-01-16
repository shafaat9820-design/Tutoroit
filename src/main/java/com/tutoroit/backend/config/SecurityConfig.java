//package com.tutoroit.backend.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http
//                .csrf(csrf -> csrf.disable())
//
//                .authorizeHttpRequests(auth -> auth
//                        // ✅ PUBLIC APIs
//                        .requestMatchers(
//                                "/api/auth/register",
//                                "/api/auth/login",
//                                "/api/posts",          // GET all posts
//                                "/api/posts/**"
//                        ).permitAll()
//
//                        // ❌ everything else secured
//                        .anyRequest().authenticated()
//                )
//
//                // ❌ no session (REST API)
//                .sessionManagement(session ->
//                        session.sessionCreationPolicy(
//                                org.springframework.security.config.http.SessionCreationPolicy.STATELESS
//                        )
//                );
//
//        return http.build();
//    }
//}
