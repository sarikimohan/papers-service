package com.papers.exception;



import com.papers.exception.custom.*;
import com.papers.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.IllegalArgumentException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        // Log validation errors
        log.error("Validation errors occurred: {}", errors);

        return ResponseEntity.badRequest().body(errors);
        }

    // Handle Resource Not Found (404)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
        log.error("Resource not found: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(ErrorResponse.builder()
                .error("Resource Not Found")
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(System.currentTimeMillis())
                .build(), HttpStatus.NOT_FOUND );
    }

    // Handle Validation Errors (400)
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException ex){
        log.error("Validation error: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(ErrorResponse.builder()
                .error("Validation error")
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(System.currentTimeMillis())
                .build(), HttpStatus.BAD_REQUEST);
    }

    // Handle Illegal Arguments (400)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("Invalid argument: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(ErrorResponse.builder()
                .error("Invalid Argument")
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(System.currentTimeMillis())
                .build(), HttpStatus.BAD_REQUEST);
    }

    // Handle Unauthorized Access (401)
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorizedException(UnauthorizedException ex) {
        log.error("Unauthorized access: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(ErrorResponse.builder()
                .error("Unauthorized")
                .message(ex.getMessage())
                .status(HttpStatus.UNAUTHORIZED.value())
                .timestamp(System.currentTimeMillis())
                .build(), HttpStatus.UNAUTHORIZED);
    }

    // Handle Forbidden Access (403)
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ErrorResponse> handleForbiddenException(ForbiddenException ex) {
        // Log the error with context
        log.error("Forbidden access: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(ErrorResponse.builder()
                .error("Forbidden")
                .message(ex.getMessage())
                .status(HttpStatus.FORBIDDEN.value())
                .timestamp(System.currentTimeMillis())
                .build(), HttpStatus.FORBIDDEN);
    }

    // Handle Duplicate Resources (409)
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateResourceException(DuplicateResourceException ex) {
        log.error("Duplicate resource: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(ErrorResponse.builder()
                .error("Conflict").message(ex.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .timestamp(System.currentTimeMillis())
                .build(), HttpStatus.CONFLICT);
    }

    // Handle Generic Errors (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        log.error("Internal server error: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(ErrorResponse.builder()
                .error("Internal Server Error")
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(System.currentTimeMillis())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }





}
