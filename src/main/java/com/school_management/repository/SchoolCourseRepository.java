package com.school_management.repository;

import com.school_management.models.SchoolCourse;
import com.school_management.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolCourseRepository extends JpaRepository<SchoolCourse, Long> {

    SchoolCourse findByCourseNameAndTeacherId(String courseName, Long teacherId);

    SchoolCourse findByTeacherId(Long id);

    SchoolCourse findByCourseName(String courseName);
}
