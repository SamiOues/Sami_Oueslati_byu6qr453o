package com.school_management.controllers;

import com.school_management.models.SchoolCourse;
import com.school_management.service.SchoolCourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/school-courses")
public class SchoolCourseController {
    private final SchoolCourseService schoolCourseService;

    public SchoolCourseController(SchoolCourseService schoolCourseService) {
        this.schoolCourseService = schoolCourseService;
    }

    @GetMapping
    public List<SchoolCourse> getAllSchoolCourses() {
        return schoolCourseService.getAllSchoolCourses();
    }

    @GetMapping("/{id}")
    public SchoolCourse getSchoolCourseById(@PathVariable Long id) {
        return schoolCourseService.getSchoolCourseById(id);
    }

    @PostMapping
    public SchoolCourse createSchoolCourse(@RequestBody SchoolCourse schoolCourse) {
        return schoolCourseService.createSchoolCourse(schoolCourse);
    }

    @PutMapping("/{id}")
    public SchoolCourse updateSchoolCourse(@PathVariable Long id, @RequestBody SchoolCourse schoolCourse) {
        schoolCourse.setId(id);
        return schoolCourseService.updateSchoolCourse(schoolCourse);
    }

    @DeleteMapping("/{id}")
    public void deleteSchoolCourse(@PathVariable Long id) {
        schoolCourseService.deleteSchoolCourse(id);
    }
}
