package com.example.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.http.ResponseEntity;

@ControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)

    public ResponseEntity<String> handleException(Exception e) {

        return ResponseEntity.status(500).body("Something went wrong: " + e.getMessage());

    }

}

