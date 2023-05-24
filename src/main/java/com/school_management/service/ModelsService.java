package com.school_management.service;

import com.school_management.models.SchoolCourse;
import com.school_management.models.Student;
import com.school_management.models.Teacher;
import com.school_management.payload.CourseRequest;
import com.school_management.payload.StudentRequest;
import com.school_management.payload.TeacherRequest;
import com.school_management.repository.SchoolCourseRepository;
import com.school_management.repository.StudentRepository;
import com.school_management.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelsService {

    private final StudentRepository studentRepository;

    private final SchoolCourseRepository schoolCourseRepository;

    private final TeacherRepository teacherRepository;

    public SchoolCourse saveCourse(CourseRequest request){
        var schoolCourse = new SchoolCourse(request.getCourseName());
        schoolCourseRepository.save(schoolCourse);
        return schoolCourse;
    }
    public Teacher saveTeacher(TeacherRequest request){
        var teacher = new Teacher(request.getTeacherFirstName(),request.getTeacherLastName(),request.getSchoolCourse());
        teacherRepository.save(teacher);
        return teacher;
    }
    public Student saveStudent(StudentRequest request){
        var student = new Student(request.getFirstName(),request.getLastName(),request.getSchoolCourse());
        studentRepository.save(student);
        return student;
    }
}
