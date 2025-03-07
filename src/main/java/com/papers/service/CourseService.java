package com.papers.service;

import com.papers.model.db.Course;
import com.papers.model.dto.CreateCourseRequest;
import com.papers.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

  @Autowired private CourseRepository courseRepository;

  public void createCourse(CreateCourseRequest createCourseRequest) {
    courseRepository.save(
        Course.builder()
            .courseName(createCourseRequest.getCourseName())
            .courseCode(createCourseRequest.getCourseCode())
            .departmentId(createCourseRequest.getDepartmentId())
            .build());
  }

  public List<Course> fetchAllCourses(String departmentId){
    return courseRepository.findAllByDepartmentId(departmentId);
  }

}
