package com.papers.controller;

import com.papers.model.dto.CreateCollegeRequest;
import com.papers.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/college")
public class CollegeController {

    @Autowired private CollegeService collegeService;


    @PostMapping
    public ResponseEntity<String> createCollege(@RequestBody CreateCollegeRequest createCollegeRequest){
        collegeService.createCollege(createCollegeRequest);

        return ResponseEntity.ok("college created successfully");
    }
}
