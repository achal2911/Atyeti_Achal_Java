package com.vehiclerentalsystem.model;

public class Truck extends Vehicle{



    public Truck(String vehicleID, String vehicleType, String vehicleBrand, int rentPerDay, boolean isAvailable) {
        super(vehicleID, vehicleType, vehicleBrand, rentPerDay, isAvailable);
    }

    @Override
    public double calculateRent(int days)
    {
        return getRentPerDay()*days;
    }
}
