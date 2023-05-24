package com.school_management.repository;

import com.school_management.models.SchoolCourse;
import com.school_management.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findBySchoolCourseId(Long id, Pageable pageable);


    Page<Student> findBySchoolCourse(SchoolCourse course, Pageable pageable);
}