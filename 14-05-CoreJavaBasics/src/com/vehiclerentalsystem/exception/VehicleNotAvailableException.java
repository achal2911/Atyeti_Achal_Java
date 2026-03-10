package com.vehiclerentalsystem.exception;

public class VehicleNotAvailableException extends RuntimeException{
    public VehicleNotAvailableException(String msg)
    {
        super(msg);
    }
}
