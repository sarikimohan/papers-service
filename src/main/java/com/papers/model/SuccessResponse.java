package com.papers.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponse {
    private String message;
    private int status;
    private long timestamp;
    private Object data;
}



