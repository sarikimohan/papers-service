package com.papers.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateExamPaperRequest {
    private String examPaperName;
    private String courseId;
    private String pdfURL;
}
