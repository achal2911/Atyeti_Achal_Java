package com.example.exception;

public class EmailSendException extends RuntimeException {
    public EmailSendException(String msg) {
        super(msg);
    }
}
