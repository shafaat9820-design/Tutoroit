//package com.tutoroit.backend.config;
//
//import com.tutoroit.backend.service.CustomUserDetailsService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    private final CustomUserDetailsService userDetailsService;
//
//    public JwtAuthenticationFilter(CustomUserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Override
//    protected void doFilterInternal(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain filterChain
//    ) throws ServletException, IOException {
//
//        String authHeader = request.getHeader("Authorization");
//
//        String email = null;
//        String token = null;
//
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            token = authHeader.substring(7);
//            if (JwtUtil.isTokenValid(token)) {
//                email = JwtUtil.extractEmail(token);
//            }
//        }
//
//        if (email != null &&
//                SecurityContextHolder.getContext().getAuthentication() == null) {
//
//            var userDetails =
//                    userDetailsService.loadUserByUsername(email);
//
//            UsernamePasswordAuthenticationToken authentication =
//                    new UsernamePasswordAuthenticationToken(
//                            userDetails,
//                            null,
//                            userDetails.getAuthorities()
//                    );
//
//            authentication.setDetails(
//                    new WebAuthenticationDetailsSource()
//                            .buildDetails(request)
//            );
//
//            SecurityContextHolder.getContext()
//                    .setAuthentication(authentication);
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
