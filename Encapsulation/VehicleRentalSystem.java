package Encapsulation;

import java.util.ArrayList;
import java.util.List;

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Getters and setters (Encapsulation)
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    // Abstract method to calculate rental cost
    public abstract double calculateRentalCost(int days);

    // Display common vehicle details
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per Day: " + rentalRate);
    }
}

// Interface Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Car class
class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;
    private double insuranceRate = 0.05; // 5% of rental rate per day

    public Car(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, type, rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * insuranceRate;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Policy: " + "Policy Number: " + insurancePolicyNumber + ", Rate: " + (insuranceRate * 100) + "%";
    }
}

// Bike class
class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;
    private double insuranceRate = 0.03; // 3% of rental rate per day

    public Bike(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, type, rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * insuranceRate;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Policy: " + "Policy Number: " + insurancePolicyNumber + ", Rate: " + (insuranceRate * 100) + "%";
    }
}

// Truck class
class Truck extends Vehicle {
    private double extraFeePerDay = 50.0; // Additional fee for truck rentals

    public Truck(String vehicleNumber, String type, double rentalRate) {
        super(vehicleNumber, type, rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() + extraFeePerDay) * days;
    }

    // Trucks are not insurable, so no implementation of Insurable
}

// Main class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        // List to store vehicles
        List<Vehicle> vehicles = new ArrayList<>();

        // Adding vehicles to the list
        vehicles.add(new Car("C101", "Car", 1000, "CAR12345"));
        vehicles.add(new Bike("B202", "Bike", 500, "BIKE98765"));
        vehicles.add(new Truck("T303", "Truck", 1500));

        // Iterate over vehicles and calculate costs
        for (Vehicle vehicle : vehicles) {
            System.out.println("=================================");
            vehicle.displayDetails();

            int rentalDays = 5; // Example rental duration
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            System.out.println("Rental Cost for " + rentalDays + " days: " + rentalCost);

            if (vehicle instanceof Insurable) {
                Insurable insurable = (Insurable) vehicle;
                System.out.println(insurable.getInsuranceDetails());
                System.out.println("Insurance Cost: " + insurable.calculateInsurance());
            } else {
                System.out.println("This vehicle is not insurable.");
            }
            System.out.println("=================================");
        }
    }
}
