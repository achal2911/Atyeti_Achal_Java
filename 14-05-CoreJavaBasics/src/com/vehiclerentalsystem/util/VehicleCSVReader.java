package com.vehiclerentalsystem.util;

import com.vehiclerentalsystem.model.Bike;
import com.vehiclerentalsystem.model.Car;
import com.vehiclerentalsystem.model.Truck;
import com.vehiclerentalsystem.model.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleCSVReader {


    public static List<Vehicle> vehicleDataFileReader(String filepath) {

        String line;

        List<Vehicle> vehicleList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] vehicleData = line.split(",");
                if (vehicleData.length == 5) {
                    String vehicleID = vehicleData[0];
                    String vehicleType = vehicleData[1];
                    String vehicleBrand = vehicleData[2];
                    int rentPerDay = Integer.parseInt(vehicleData[3]);
                    boolean isAvailable = Boolean.parseBoolean(vehicleData[4]);

                    Vehicle vehicle = null;
                    switch (vehicleType.toLowerCase()) {
                        case "car":
                            vehicle = new Car(vehicleID, vehicleType, vehicleBrand, rentPerDay, isAvailable);
                            break;
                        case "bike":
                            vehicle = new Bike(vehicleID, vehicleType, vehicleBrand, rentPerDay, isAvailable);
                            break;
                        case "truck":
                            vehicle = new Truck(vehicleID, vehicleType, vehicleBrand, rentPerDay, isAvailable);
                            break;
                        default:
                            System.out.println("Unknown vehicle type: " + vehicleType);
                    }

                    if (vehicle != null) {
                        vehicleList.add(vehicle);
                    }


                } else {
                    System.out.println("Skipping malformed line: " + line);
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return vehicleList;

    }

}
