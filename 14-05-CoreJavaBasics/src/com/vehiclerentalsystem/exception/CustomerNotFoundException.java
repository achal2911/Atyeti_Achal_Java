package com.vehiclerentalsystem.exception;

public class CustomerNotFoundException extends RuntimeException{

    public  CustomerNotFoundException(String msg)
    {
        super(msg);
    }
}
