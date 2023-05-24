# School Management Application
This is a School Management application developed as an exercise for a job test. It is built using the Spring Boot framework.

# Project Overview
The School Management application aims to provide a comprehensive system for managing various aspects of a school, including students, teachers, courses, and administrative tasks. The application offers the following features:

# CRUD operations for managing students, teachers, and courses.
User authentication and authorization.
API documentation using Swagger.
Spring Boot 3.0 Security with JWT Implementation
This project demonstrates the implementation of security using Spring Boot 3.0 and JSON Web Tokens (JWT). It includes the following features:

# Features
User registration and login with JWT authentication
Password encryption using BCrypt
Role-based authorization with Spring Security
Customized access denied handling
Logout mechanism
Refresh token
# Technologies
- Spring Boot 3.0
- Spring Security
- JSON Web Tokens (JWT)
- BCrypt
- Maven
- Swagger
- MySql
# Getting Started
To run the School Management application locally, please follow the instructions below:

# Prerequisites
Make sure you have the following software installed on your system:

- Java Development Kit (JDK) 17 or above
- Maven
- MySQL or any other compatible database server
# Installation
Clone the repository to your local machine:


```bash
git clone https://github.com/SamiOues/Sami_Oueslati_byu6qr453o.git
```

Navigate to the project directory:

```bash
cd school-management-application
```
Build the project using Maven:

```bash
mvn clean install
```
# Configuration
Before running the application, you need to configure the database connection. Open the application.properties file located in the src/main/resources directory and update the following properties with your database credentials:
```bash
    url: jdbc:mysql://localhost:3306/schoolmanagement
    username: root
    password:
```

# Running the Application
To run the School Management application, execute the following command:
```bash
mvn spring-boot:run
```
The application will start running on http://localhost:8080.

# Testing
The application has been pre-populated with some initial data to facilitate testing. The following entities are already available in the database:

- Students: Three students have been inserted.
- Teacher: One teacher named Jean Luc.
- Course: One course named Math.
* ### Additionally, an admin user has been created with the following credentials:

- First Name: Admin
- Last Name: Admin
- Email: admin@mail.com
- Password: password
- Role: ADMIN
  You can use these credentials to log in and explore the application's functionality.

# Unit Testing
```bash
mvn test
```

# API Documentation
The API documentation for the School Management application is available using Swagger. You can access it by opening the following URL in your browser:

http://localhost:8080/swagger-ui/index.html#/


# Acknowledgments
Special thanks to ChatGpt, Stack Overflow and Spring boot JWT official Documentation.
