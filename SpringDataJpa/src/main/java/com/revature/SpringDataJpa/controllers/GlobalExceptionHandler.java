package com.revature.SpringDataJpa.controllers;

import com.revature.SpringDataJpa.Exception.ErrorResponse;
import com.revature.SpringDataJpa.Exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleGlobalException(NotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),exception.getMessage(),"Error Occurred");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
