// File: exception/EmployeeNotFoundException.java
package com.example.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
