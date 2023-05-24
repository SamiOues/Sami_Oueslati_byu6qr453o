package com.school_management.payload;

import com.school_management.enums.Role;
import com.school_management.models.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

  private String courseName;

}
