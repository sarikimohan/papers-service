package com.papers.service;

import com.papers.model.db.ExamPaper;
import com.papers.model.dto.CreateExamPaperRequest;
import com.papers.repository.ExamPaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamPaperService {

  @Autowired private ExamPaperRepository examPaperRepository;

  public void createExamPaper(CreateExamPaperRequest createExamPaperRequest) {
    examPaperRepository.save(
        ExamPaper.builder()
            .examPaperName(createExamPaperRequest.getExamPaperName())
            .courseId(createExamPaperRequest.getCourseId())
            .pdfURL(createExamPaperRequest.getPdfURL())
            .build());
  }

  public List<ExamPaper> fetchAllExamPapers(String courseId){
    return examPaperRepository.findAllByCourseId(courseId);
  }

}
