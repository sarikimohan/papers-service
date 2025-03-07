package com.papers.controller;


import com.papers.model.dto.CreateExamPaperRequest;
import com.papers.service.ExamPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/exam-paper")
public class ExamPaperController {
    @Autowired private ExamPaperService examPaperService;

    @PostMapping
    private ResponseEntity<?> createExamPaper(@RequestBody CreateExamPaperRequest createExamPaperRequest){
        examPaperService.createExamPaper(createExamPaperRequest);

        return ResponseEntity.ok("Exam paper created successfully");
    }

    @GetMapping("/{course-id}")
    private ResponseEntity<?> fetchAllExamPapers(@PathVariable("course-id") String courseId){
        return ResponseEntity.ok(examPaperService.fetchAllExamPapers(courseId));
    }

}
