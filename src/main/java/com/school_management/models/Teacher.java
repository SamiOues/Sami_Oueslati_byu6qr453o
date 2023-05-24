package com.school_management.models;

import jakarta.persistence.*;


@Entity
@Table(name="teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String teacherFirstName;

    private String teacherLastName;

    @OneToOne
    @JoinColumn(name = "schoolCourse")
    private SchoolCourse schoolCourse;

    public Teacher() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public SchoolCourse getSchoolCourse() {
        return schoolCourse;
    }

    public void setSchoolCourse(SchoolCourse schoolCourse) {
        this.schoolCourse = schoolCourse;
    }

    public Teacher(Long id, String teacherFirstName, String teacherLastName, SchoolCourse schoolCourse) {
        this.id = id;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.schoolCourse = schoolCourse;
    }
    public Teacher(String teacherFirstName, String teacherLastName, SchoolCourse schoolCourse) {
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.schoolCourse = schoolCourse;
    }


}
