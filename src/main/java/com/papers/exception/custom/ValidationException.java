package com.papers.exception.custom;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
