package com.school_management.payload;

import com.school_management.enums.Role;
import com.school_management.models.SchoolCourse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

  private String firstName;
  private String lastName;
  private SchoolCourse schoolCourse;
}
