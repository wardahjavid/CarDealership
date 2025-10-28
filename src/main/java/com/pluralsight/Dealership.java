package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> vehicles;

    // Constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = new ArrayList<>();
    }

    // Getters
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }

    // Return all vehicles
    public ArrayList<Vehicle> getAllVehicles() {
        return vehicles;
    }

    // Add a vehicle
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    // Remove vehicle by VIN
    public void removeVehicle(int vin) {
        boolean removed = vehicles.removeIf(v -> v.getVin() == vin);
        if (removed) {
            System.out.println("Vehicle with VIN " + vin + " removed.");
        } else {
            System.out.println("No vehicle found with VIN " + vin + ".");
        }
    }

    // ------------------------------------------------------------------
    // SEARCH METHODS
    // ------------------------------------------------------------------

    // 1. Find by price range
    public ArrayList<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getPrice() >= minPrice && v.getPrice() <= maxPrice) {
                matches.add(v);
            }
        }
        return matches;
    }

    // 2. Find by make and model
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getMake().equalsIgnoreCase(make) &&
                    v.getModel().equalsIgnoreCase(model)) {
                matches.add(v);
            }
        }
        return matches;
    }

    // 3. Find by year range
    public ArrayList<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getYear() >= minYear && v.getYear() <= maxYear) {
                matches.add(v);
            }
        }
        return matches;
    }

    // 4. Find by color
    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getColor().equalsIgnoreCase(color)) {
                matches.add(v);
            }
        }
        return matches;
    }

    // 5. Find by mileage
    public ArrayList<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getOdometer() >= minMileage && v.getOdometer() <= maxMileage) {
                matches.add(v);
            }
        }
        return matches;
    }

    // 6. Find by type
    public ArrayList<Vehicle> getVehiclesByType(String type) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getType().equalsIgnoreCase(type)) {
                matches.add(v);
            }
        }
        return matches;
    }

    // ------------------------------------------------------------------
    // Optional: Display summary info
    // ------------------------------------------------------------------
    public void printSummary() {
        System.out.println("Dealership: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("Vehicles in inventory: " + vehicles.size());
    }
}
