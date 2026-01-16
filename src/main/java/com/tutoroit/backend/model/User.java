package com.tutoroit.backend.model;

import jakarta.persistence.*;

/**
 * User Entity
 * Ye table sab users ke liye hai:
 * TUTOR / STUDENT / PARENT
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Register time pe aayega
    private String name;

    // Login email
    @Column(unique = true, nullable = false)
    private String email;

    // Login password (abhi plain text, baad me encrypt karenge)
    private String password;

    // Tutor ka contact number
    private String mobile;

    /**
     * Role decide karega:
     * - TUTOR → post create + view
     * - STUDENT / PARENT → sirf view
     */
    @Enumerated(EnumType.STRING)
    private Role role;

    // ================= GETTERS & SETTERS =================

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
