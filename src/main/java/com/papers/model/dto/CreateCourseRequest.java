package com.papers.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseRequest {
    private String courseName;
    private String departmentId;
    private String courseCode;
}
