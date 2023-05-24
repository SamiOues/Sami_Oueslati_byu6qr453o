package com.school_management.service;

import com.school_management.models.SchoolCourse;
import com.school_management.repository.SchoolCourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolCourseService {
    private final SchoolCourseRepository schoolCourseRepository;

    public SchoolCourseService(SchoolCourseRepository schoolCourseRepository) {
        this.schoolCourseRepository = schoolCourseRepository;
    }

    public List<SchoolCourse> getAllSchoolCourses() {
        return schoolCourseRepository.findAll();
    }

    public SchoolCourse getSchoolCourseById(Long id) {
        return schoolCourseRepository.findById(id).orElse(null);
    }

    public SchoolCourse createSchoolCourse(SchoolCourse schoolCourse) {
        return schoolCourseRepository.save(schoolCourse);
    }

    public SchoolCourse updateSchoolCourse(SchoolCourse schoolCourse) {
        return schoolCourseRepository.save(schoolCourse);
    }

    public void deleteSchoolCourse(Long id) {
        schoolCourseRepository.deleteById(id);
    }
}
