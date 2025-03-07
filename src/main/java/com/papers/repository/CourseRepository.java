package com.papers.repository;

import com.papers.model.db.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CourseRepository extends MongoRepository<Course,String> {

    List<Course> findAllByDepartmentId(String departmentId);
}
