package com.papers.repository;

import com.papers.model.db.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository  extends MongoRepository<Department,String> {
}
