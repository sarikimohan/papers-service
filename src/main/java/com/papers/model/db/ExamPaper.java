package com.papers.model.db;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "exam_paper")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamPaper {

    @Id
    private String examPaperId;
    private String examPaperName;
    private String pdfURL;
    private String courseId;

}
