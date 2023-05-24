package com.school_management;

import com.school_management.models.SchoolCourse;
import com.school_management.models.Teacher;
import com.school_management.payload.CourseRequest;
import com.school_management.payload.StudentRequest;
import com.school_management.payload.TeacherRequest;
import com.school_management.service.AuthenticationService;
import com.school_management.payload.RegisterRequest;
import com.school_management.service.ModelsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.school_management.enums.Role.ADMIN;
import static com.school_management.enums.Role.MANAGER;

@SpringBootApplication
public class SchoolManagement {

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagement.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service,
			ModelsService modelsService
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("admin@mail.com")
					.password("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var courseMath = CourseRequest.builder()
					.courseName("Math")
					.build();
			SchoolCourse course = modelsService.saveCourse(courseMath);
			var teacherMath = TeacherRequest.builder()
					.teacherFirstName("Jean")
					.teacherLastName("Luc")
					.schoolCourse(course)
					.build();
			modelsService.saveTeacher(teacherMath);
			var student1 = StudentRequest.builder()
					.firstName("Elise")
					.lastName("Blue")
					.schoolCourse(course)
					.build();
			modelsService.saveStudent(student1);
			var student2 = StudentRequest.builder()
					.firstName("Caitlyn")
					.lastName("Yellow")
					.schoolCourse(course)
					.build();
			modelsService.saveStudent(student2);
			var student3 = StudentRequest.builder()
					.firstName("Mohsen")
					.lastName("Bard")
					.schoolCourse(course)
					.build();
			modelsService.saveStudent(student3);
		};
	}
}
