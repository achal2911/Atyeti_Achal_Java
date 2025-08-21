package com.example.expensetracker.exception;

class Example {
    private static final ThreadLocal<String> currentUser = new ThreadLocal<>();

    public static void main(String[] args) {
        currentUser.set("Achal"); // put value in this thread's box
        System.out.println(currentUser.get()); // Achal
        currentUser.remove(); // clean up manually
    }
}

public class ValidationException extends RuntimeException
{
    public ValidationException(String msg)
    {
        super(msg);
    }
}
