package com.school_management.service;
import com.school_management.models.SchoolCourse;
import com.school_management.models.Student;
import com.school_management.models.Teacher;
import com.school_management.repository.SchoolCourseRepository;
import com.school_management.repository.StudentRepository;
import com.school_management.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final SchoolCourseRepository schoolCourseRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository,
                          SchoolCourseRepository schoolCourseRepository,
                          TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.schoolCourseRepository = schoolCourseRepository;
        this.teacherRepository = teacherRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    public ResponseEntity <Page<Student>> getStudentsWithFilters (String courseName, String teacherFullName, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

        if (courseName != null && teacherFullName != null && !courseName.isEmpty() && !teacherFullName.isEmpty()) {
            return getStudentsByCourseNameAndTeacherFullName(courseName, teacherFullName, pageable);
        } else if (courseName != null && !courseName.isEmpty()) {
            return getStudentsByCourseName(courseName, pageable);
        } else if (teacherFullName != null && !teacherFullName.isEmpty()) {
            return getStudentsByTeacherFullName(teacherFullName, pageable);
        } else {
            return getAllStudentsNoFilter(pageable);
        }
    }
    private ResponseEntity <Page<Student>> getStudentsByCourseNameAndTeacherFullName(String courseName, String teacherFullName, Pageable pageable) {
        String[] teacherFullNameSplit = teacherFullName.split(" ");
        Teacher teacher = teacherRepository.findByTeacherFirstNameAndTeacherLastName(teacherFullNameSplit[0], teacherFullNameSplit[1]);

        SchoolCourse schoolCourse = schoolCourseRepository.findByCourseNameAndTeacherId(courseName, teacher.getId());
        if (schoolCourse != null) {
            return ResponseEntity.ok(studentRepository.findBySchoolCourseId(schoolCourse.getId(), pageable));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    private ResponseEntity <Page<Student>> getStudentsByCourseName(String courseName, Pageable pageable) {
        SchoolCourse course = schoolCourseRepository.findByCourseName(courseName);
        return ResponseEntity.ok(studentRepository.findBySchoolCourse(course, pageable));
    }
    private ResponseEntity <Page<Student>> getStudentsByTeacherFullName(String teacherFullName, Pageable pageable){
        String[] teacherFullNameSplit = teacherFullName.split(" ");
        Teacher teacher = teacherRepository.findByTeacherFirstNameAndTeacherLastName(teacherFullNameSplit[0], teacherFullNameSplit[1]);

        SchoolCourse schoolCourse = schoolCourseRepository.findByTeacherId(teacher.getId());
        if (schoolCourse != null) {
            return ResponseEntity.ok(studentRepository.findBySchoolCourseId(schoolCourse.getId(), pageable));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    private ResponseEntity <Page<Student>> getAllStudentsNoFilter(Pageable pageable) {
        return ResponseEntity.ok(studentRepository.findAll(pageable));
    }



}
