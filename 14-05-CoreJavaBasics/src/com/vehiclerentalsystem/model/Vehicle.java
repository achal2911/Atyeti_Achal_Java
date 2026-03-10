package com.vehiclerentalsystem.model;

public abstract class Vehicle {

    private String VehicleID;
    private String vehicleType;
    private String vehicleBrand;
    private int rentPerDay;
    protected boolean isAvailable;



    public Vehicle(String vehicleID, String vehicleType, String vehicleBrand, int rentPerDay, boolean isAvailable) {
        VehicleID = vehicleID;
        this.vehicleType = vehicleType;
        this.vehicleBrand = vehicleBrand;
        this.rentPerDay = rentPerDay;
        this.isAvailable = isAvailable;
    }

    public abstract double calculateRent(int days);

    public String getVehicleID() {
        return VehicleID;
    }



    public void setVehicleID(String vehicleID) {
        VehicleID = vehicleID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public int getRentPerDay() {
        return rentPerDay;
    }


    public void setRentPerDay(int rentPerDay) {
        this.rentPerDay = rentPerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "VehicleID=" + VehicleID +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleBrand='" + vehicleBrand + '\'' +
                ", rentPerDay=" + rentPerDay +
                ", isAvailable=" + isAvailable +
                '}';
    }


    //
}
