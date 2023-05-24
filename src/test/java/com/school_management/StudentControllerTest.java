package com.school_management;

import com.school_management.controllers.StudentController;
import com.school_management.models.Student;
import com.school_management.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.springframework.data.domain.Page;


class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllStudents_shouldReturnListOfStudents() {
        // Arrange
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "John", "Doe", null));
        students.add(new Student(2L, "Alice", "Smith", null));

        when(studentService.getAllStudents()).thenReturn(students);

        // Act
        List<Student> result = studentController.getAllStudents();

        // Assert
        assertEquals(students, result);
        verify(studentService, times(1)).getAllStudents();
    }

    @Test
    void getStudentById_withValidId_shouldReturnStudent() {
        // Arrange
        Long id = 1L;
        Student student = new Student(id, "John", "Doe", null);

        when(studentService.getStudentById(id)).thenReturn(student);

        // Act
        Student result = studentController.getStudentById(id);

        // Assert
        assertEquals(student, result);
        verify(studentService, times(1)).getStudentById(id);
    }

    // Similarly, you can write tests for the other methods

    // Remember to test error scenarios and edge cases as well

    @Test
    void deleteStudent_withValidId_shouldCallDeleteStudentInService() {
        // Arrange
        Long id = 1L;

        // Act
        studentController.deleteStudent(id);

        // Assert
        verify(studentService, times(1)).deleteStudent(id);
    }

    @Test
    void getStudents_withFilters_shouldReturnPageOfStudents() {
        // Arrange
        String courseName = "Math";
        String teacherFullName = "Smith";
        int page = 0;
        int pageSize = 10;

        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "John", "Doe", null));
        students.add(new Student(2L, "Alice", "Smith", null));

        Page<Student> studentPage = new PageImpl<>(students, PageRequest.of(page, pageSize), students.size());

        when(studentService.getStudentsWithFilters(courseName, teacherFullName, page, pageSize))
                .thenReturn(ResponseEntity.ok(studentPage));

        // Act
        ResponseEntity<Page<Student>> result = studentController.getStudents(courseName, teacherFullName, page, pageSize);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(studentPage, result.getBody());
        verify(studentService, times(1)).getStudentsWithFilters(courseName, teacherFullName, page, pageSize);
    }
}

