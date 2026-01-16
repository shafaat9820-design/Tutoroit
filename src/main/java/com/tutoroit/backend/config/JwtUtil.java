//package com.tutoroit.backend.config;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//
//import java.security.Key;
//import java.util.Date;
//
//public class JwtUtil {
//
//    // 🔐 Secret key (minimum 32 chars for HS256)
//    private static final String SECRET_KEY =
//            "tutoroit-secret-key-tutoroit-secret-key";
//
//    // ⏳ Token validity (1 day)
//    private static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000;
//
//    private static final Key KEY =
//            Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
//
//    // =========================
//    // GENERATE TOKEN
//    // =========================
//    public static String generateToken(String email, String role) {
//
//        return Jwts.builder()
//                .setSubject(email)
//                .claim("role", role)
//                .setIssuedAt(new Date())
//                .setExpiration(
//                        new Date(System.currentTimeMillis() + EXPIRATION_TIME)
//                )
//                .signWith(KEY, SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    // =========================
//    // EXTRACT EMAIL
//    // =========================
//    public static String extractEmail(String token) {
//        return getClaims(token).getSubject();
//    }
//
//    // =========================
//    // EXTRACT ROLE
//    // =========================
//    public static String extractRole(String token) {
//        return getClaims(token).get("role", String.class);
//    }
//
//    // =========================
//    // TOKEN VALIDATION
//    // =========================
//    public static boolean isTokenValid(String token) {
//        try {
//            getClaims(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    // =========================
//    // INTERNAL: PARSE CLAIMS
//    // =========================
//    private static Claims getClaims(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(KEY)
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
//}
