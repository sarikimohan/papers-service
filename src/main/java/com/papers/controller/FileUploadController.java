package com.papers.controller;

import com.papers.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class FileUploadController {

    private final S3Service s3Service;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty() || !file.getContentType().equals("application/pdf")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid file format. Only PDFs are allowed.");
            }

            // Upload file to S3 and get the URL
            String fileUrl = s3Service.uploadFile(file);

            // Save file URL in MongoDB
//            DocumentEntity document = documentRepository.save(new DocumentEntity(null, fileUrl));

            return ResponseEntity.ok(fileUrl);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed: " + e.getMessage());
        }
    }
}

