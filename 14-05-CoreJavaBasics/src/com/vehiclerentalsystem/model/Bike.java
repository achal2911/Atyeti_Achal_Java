package com.vehiclerentalsystem.model;

public class Bike extends  Vehicle{


    public Bike(String vehicleID, String vehicleType, String vehicleBrand, int rentPerDay, boolean isAvailable) {
        super(vehicleID, vehicleType, vehicleBrand, rentPerDay, isAvailable);
    }

    @Override
    public double calculateRent(int days)
    {
        return getRentPerDay()*days;
    }
}
