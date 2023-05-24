package com.school_management.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "schoolCourse")
    private SchoolCourse schoolCourse;

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SchoolCourse getSchoolCourse() {
        return schoolCourse;
    }

    public void setSchoolCourse(SchoolCourse schoolCourse) {
        this.schoolCourse = schoolCourse;
    }

    public Student(Long id,String firstName, String lastName, SchoolCourse schoolCourse) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.schoolCourse = schoolCourse;
    }

    public Student(String firstName, String lastName, SchoolCourse schoolCourse) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.schoolCourse = schoolCourse;
    }
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



}
