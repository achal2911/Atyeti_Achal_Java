package com.vehiclerentalsystem.service;

import com.vehiclerentalsystem.exception.CustomerNotFoundException;
import com.vehiclerentalsystem.exception.VehicleNotAvailableException;
import com.vehiclerentalsystem.model.Customer;
import com.vehiclerentalsystem.model.Vehicle;
import com.vehiclerentalsystem.util.VehicleCSVReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class RentalServices {

    private List<Vehicle> vehicles = new ArrayList<>();
    private Map<String, Customer> customers = new HashMap<>();

    //adding Vehicle
    public void addVehicles(Vehicle vehicle) {
        vehicles.add(vehicle);
        //System.out.println("Vehicle added successfully!!");

    }

    //register customer data
    public void registerCustomer(Customer customer) {
        if (customer != null) {
            customers.put(customer.getCustomerId(), customer);
            System.out.println("customer registered successfully!");
        } else {
            throw new IllegalStateException("Invalid Data");
        }

    }

    //showing all vehicles
    public void showAvailableVehicles() {
//
        List<Vehicle> vehicleList = VehicleCSVReader.vehicleDataFileReader("C:\\Users\\Achal Tikale\\OneDrive - Atyeti Inc\\JavaJourneyRecap\\14-05-CoreJavaBasics\\src\\com\\vehiclerentalsystem\\util\\availableVehicle.csv");
        vehicleList.forEach(System.out::println);
    }

    //renting vehicle
    public void rentVehicle(String customerId, String vehicleId, int days) {
        Customer customer = customers.get(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer Not Found!");
        }

        String csvFilePath = "C:\\Users\\Achal Tikale\\OneDrive - Atyeti Inc\\JavaJourneyRecap\\14-05-CoreJavaBasics\\src\\com\\vehiclerentalsystem\\util\\availableVehicle.csv";
        List<Vehicle> vehicleList = VehicleCSVReader.vehicleDataFileReader(csvFilePath);
        boolean vehicleRented = false;

        for (Vehicle v : vehicleList) {
            if (v.getVehicleID().equals(vehicleId)) {
                if (v.isAvailable()) {
                    v.setAvailable(false);
                    customer.setRentedVehicle(v);
                    customer.setRentalDays(days);
                    vehicleRented = true;
                    System.out.println("Vehicle Rented Successfully!! by " + customer.getName());
                    break;
                } else {
                    throw new VehicleNotAvailableException("Vehicle not available");
                }
            }
        }

        if (!vehicleRented) {
            throw new VehicleNotAvailableException("Vehicle not found");
        }

        // Write updated vehicle list back to CSV
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath))) {
            bw.write("vehicleID,vehicleType,vehicleBrand,rentPerDay,isAvailable");
            bw.newLine();
            for (Vehicle v : vehicleList) {
                String line = String.format("%s,%s,%s,%d,%s",
                        v.getVehicleID(),
                        v.getVehicleType(),
                        v.getVehicleBrand(),
                        v.getRentPerDay(),
                        v.isAvailable());
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //returning vehicle
    public void returnVehicle(String customerId) {

        Customer customer = customers.get(customerId);
        if (customer == null || customer.getRentedVehicle() == null)
            throw new CustomerNotFoundException("Invalid return request.,Customer Not Found");

        Vehicle v = customer.getRentedVehicle();
        double total = v.calculateRent(customer.getRentalDays());
        System.out.println("Bill: Rs" + total);
        v.setAvailable(true);
        customer.setRentedVehicle(null);
    }


}
