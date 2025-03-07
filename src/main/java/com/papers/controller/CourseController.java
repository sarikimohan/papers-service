package com.papers.controller;

import com.papers.model.dto.CreateCourseRequest;
import com.papers.service.CourseService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/course")
public class CourseController {
    @Autowired private CourseService courseService;

    @PostMapping
    private ResponseEntity<String> createCourse(@RequestBody CreateCourseRequest createCourseRequest){
        courseService.createCourse(createCourseRequest);

        return ResponseEntity.ok("Course Created Successfully");
    }

    @GetMapping("/{department-id}")
    private ResponseEntity<?> fetchAllCourses(@PathVariable("department-id") String departmentId){
        return ResponseEntity.ok(courseService.fetchAllCourses(departmentId));
    }

}
