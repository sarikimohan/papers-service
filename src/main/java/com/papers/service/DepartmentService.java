package com.papers.service;

import com.papers.model.db.Department;
import com.papers.model.dto.CreateDepartmentRequest;
import com.papers.repository.DepartmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

  @Autowired private DepartmentRepository departmentRepository;

  public void createDepartment(CreateDepartmentRequest createDepartmentRequest) {
    departmentRepository.save(
        Department.builder()
            .departmentName(createDepartmentRequest.getDepartmentName())
            .collegeId(createDepartmentRequest.getCollegeId())
            .build());
  }

  public List<Department> fetchAllDepartments() {
    return departmentRepository.findAll();
  }
}
