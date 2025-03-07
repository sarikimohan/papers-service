package com.papers.model.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "department")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    private String departmentId;
    private String departmentName;
    private String collegeId;

}
