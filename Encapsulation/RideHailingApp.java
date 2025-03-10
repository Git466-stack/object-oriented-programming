package Encapsulation;

import java.util.ArrayList;
import java.util.List;

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    // Constructor
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Getters and setters (Encapsulation)
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    // Concrete method to display vehicle details
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
    }

    // Abstract method to calculate fare
    public abstract double calculateFare(double distance);
}

// Interface GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Subclass Car
class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Subclass Bike
class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() * 0.9; // 10% discount for bikes
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Subclass Auto
class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 10; // Flat additional charge for autos
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Main class
public class RideHailingApp {
    public static void main(String[] args) {
        // List to store vehicles
        List<Vehicle> vehicles = new ArrayList<>();

        // Adding vehicles
        vehicles.add(new Car("C001", "Alice", 12.0));
        vehicles.add(new Bike("B001", "Bob", 8.0));
        vehicles.add(new Auto("A001", "Charlie", 10.0));

        // Processing rides
        double[] distances = {15.0, 10.0, 20.0}; // Distances for each ride
        System.out.println("Processing Rides...");
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            double distance = distances[i];
            System.out.println("=================================");
            vehicle.getVehicleDetails();
            System.out.println("Distance: " + distance + " Km");
            System.out.println("Fare: " + vehicle.calculateFare(distance));

            if (vehicle instanceof GPS) {
                GPS gps = (GPS) vehicle;
                gps.updateLocation("New Location " + (i + 1));
                System.out.println("Current Location: " + gps.getCurrentLocation());
            }
            System.out.println("=================================");
        }
    }
}
