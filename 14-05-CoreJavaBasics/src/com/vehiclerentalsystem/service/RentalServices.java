package com.vehiclerentalsystem.service;

import com.vehiclerentalsystem.exception.CustomerNotFoundException;
import com.vehiclerentalsystem.exception.VehicleNotAvailableException;
import com.vehiclerentalsystem.model.Customer;
import com.vehiclerentalsystem.model.Vehicle;
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

        vehicles.forEach(System.out::println);
    }

    //renting vehicle
    public void rentVehicle(String customerId, String vehicleId, int days) {
        Customer customer = customers.get(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer Not Found!");
        }

        boolean vehicleRented = false;

        for (Vehicle v : vehicles) {
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


    }

    //returning vehicle
    public void returnVehicle(String customerId) {

        Customer customer = customers.get(customerId);
        if (customer == null || customer.getRentedVehicle() == null)
            throw new CustomerNotFoundException("Invalid return request.,Customer Not Found");

        Vehicle v = customer.getRentedVehicle();
        double total = v.calculateRent(customer.getRentalDays());
        System.out.println("Bill: Rs" + total);
        System.out.println("Vehicle returned successfully!");
        v.setAvailable(true);
        customer.setRentedVehicle(null);
    }


}
