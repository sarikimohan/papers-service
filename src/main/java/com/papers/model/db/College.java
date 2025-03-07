package com.papers.model.db;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Document(collection = "college")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class College {
    @Id
    private UUID collegeId;
    private String collegeName;
    private String imageIdx;
}
