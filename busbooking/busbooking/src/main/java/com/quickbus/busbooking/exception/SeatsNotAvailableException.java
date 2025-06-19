package com.quickbus.busbooking.exception;

public class SeatsNotAvailableException extends RuntimeException{
    public SeatsNotAvailableException(String msg)
    {
        super(msg);
    }
}
