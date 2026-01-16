package com.tutoroit.backend.model;

import jakarta.persistence.*;

/**
 * Post Entity
 * Ye tuition post ko represent karegi
 * Sirf TUTOR hi create karega
 */
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tutor ki unique identity
    private String tutorEmail;

    // Tutor ka naam (display ke liye)
    private String tutorName;

    // Tutor qualification
    private String qualification;

    // Teaching experience (e.g. 5 years)
    private String experience;

    // Which class tutor padhayega (e.g. 6-10)
    private String classToTeach;

    // Subjects (e.g. Maths, Physics)
    private String subjects;

    // Fees per month / per class
    private Double fees;

    // Tutor contact number (direct call)
    private String contactNumber;

    /**
     * NOTE:
     * Public API hai, isliye User table se join nahi kar rahe
     * Simple & fast approach
     */

    // ================= GETTERS & SETTERS =================
    public String getTutorEmail() {
        return tutorEmail;
    }

    public void setTutorEmail(String tutorEmail) {
        this.tutorEmail = tutorEmail;
    }

    public Long getId() {
        return id;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getClassToTeach() {
        return classToTeach;
    }

    public void setClassToTeach(String classToTeach) {
        this.classToTeach = classToTeach;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
