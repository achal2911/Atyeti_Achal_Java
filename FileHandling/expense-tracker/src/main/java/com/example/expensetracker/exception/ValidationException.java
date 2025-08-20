package com.example.expensetracker.exception;

public class ValidationException extends RuntimeException
{
    public ValidationException(String msg)
    {
        super(msg);
    }
}
