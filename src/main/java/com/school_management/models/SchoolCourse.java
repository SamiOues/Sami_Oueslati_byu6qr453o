package com.school_management.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name="schoolcourse")
public class SchoolCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String courseName;
    @JsonIgnore
    @OneToOne(mappedBy = "schoolCourse")
    private Teacher teacher;
    @JsonIgnore
    @OneToMany(mappedBy = "schoolCourse")
    private List<Student> students;

    public SchoolCourse() {
        students = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    public SchoolCourse(Long id, String courseName, Teacher teacher) {
        this.id = id;
        this.courseName = courseName;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }
    public SchoolCourse(String courseName){
        this.courseName = courseName;
    }
}
