package com.papers.repository;

import com.papers.model.db.ExamPaper;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExamPaperRepository extends MongoRepository<ExamPaper,String> {
    List<ExamPaper> findAllByCourseId(String courseId);
}
