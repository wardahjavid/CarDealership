package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>(); // Initialize inventory list
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }


    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(int vehicle) {
        inventory.remove(vehicle);
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                matches.add(vehicle);
            }
        }
        return matches;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make)
                    && vehicle.getModel().equalsIgnoreCase(model)) {
                matches.add(vehicle);
            }
        }
        return matches;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                matches.add(vehicle);
            }
        }
        return matches;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                matches.add(vehicle);
            }
        }
        return matches;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                matches.add(vehicle);
            }
        }
        return matches;
    }

    public ArrayList<Vehicle> getVehiclesByType(String type) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getType().equalsIgnoreCase(type)) {
                matches.add(vehicle);
            }
        }
        return matches;
    }

    public boolean removeVehicleById(int vehicleId) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicle() == vehicleId) {
                inventory.remove(vehicle);
                return true;
            }
        }
        return false;
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("No vehicles in inventory.");
            return;
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("%-8s %-6s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                "ID", "Year", "Make", "Model", "Type", "Color", "Mileage", "Price");
        System.out.println("--------------------------------------------------");

        for (Vehicle vehicle : inventory) {
            System.out.printf("%-8d %-6d %-10s %-10s %-10s %-10s %-10d $%-10.2f%n",
                    vehicle.getVehicle(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice());
        }
        System.out.println("--------------------------------------------------");
    }


}

