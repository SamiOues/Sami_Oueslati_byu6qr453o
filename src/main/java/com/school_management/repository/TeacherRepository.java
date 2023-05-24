package com.school_management.repository;

import com.school_management.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository <Teacher,Long> {
    Teacher findByTeacherFirstNameAndTeacherLastName(String teacherFirstName, String teacherLastName);
}
