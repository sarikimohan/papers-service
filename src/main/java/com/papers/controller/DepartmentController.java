package com.papers.controller;

import com.papers.model.dto.CreateDepartmentRequest;
import com.papers.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired private DepartmentService departmentService;

    @PostMapping
    private ResponseEntity<String> createDepartment(@RequestBody CreateDepartmentRequest createDepartmentRequest){
        departmentService.createDepartment(createDepartmentRequest);

        return ResponseEntity.ok("Department Created Successfully.");
    }

    @GetMapping("/all")
    private ResponseEntity<?> fetchAllDepartments(){
        return ResponseEntity.ok(departmentService.fetchAllDepartments());
    }

}
