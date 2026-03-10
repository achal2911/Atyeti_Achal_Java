package com.vehiclerentalsystem.model;

public class Car extends Vehicle {


    public Car(String vehicleID, String vehicleType, String vehicleBrand, int rentPerDay, boolean isAvailable) {
        super(vehicleID, vehicleType, vehicleBrand, rentPerDay, isAvailable);

    }


    @Override
    public double calculateRent(int days) {
        return days * getRentPerDay();
    }
}
