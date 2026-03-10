package com.vehiclerentalsystem;


import com.vehiclerentalsystem.model.Bike;
import com.vehiclerentalsystem.model.Car;
import com.vehiclerentalsystem.model.Customer;
import com.vehiclerentalsystem.model.Truck;
import com.vehiclerentalsystem.service.RentalServices;

public class VehicleRentalSystemMain {
    public static void main(String[] args) {

        RentalServices service = new RentalServices();
        service.addVehicles(new Car("C101", "Car", "Xylo", 1, true));
        service.addVehicles(new Bike("B201", "Bike", "Yamaha", 500, true));
        service.addVehicles(new Truck("T301", "Truck", "TATA", 2500,true));


        Customer c1 = new Customer("U001", "Achal Tikale");
        service.registerCustomer(c1);
        System.out.println("---------------------------------------");

        service.showAvailableVehicles();

        try {
            service.rentVehicle("U001", "B201", 3);
            //return vehicle
            service.returnVehicle("U001");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}

