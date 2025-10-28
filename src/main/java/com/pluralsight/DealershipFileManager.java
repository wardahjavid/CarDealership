package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {
    private static final String FILE_NAME = "dealership.csv";

    public Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String firstLine = reader.readLine();
            if (firstLine == null || firstLine.trim().isEmpty()) {
                System.out.println("Warning: dealership.csv is empty.");
                return new Dealership("Unnamed Dealership", "Unknown Address", "000-000-0000");
            }

            String[] dealerParts = firstLine.split("\\|");
            dealership = new Dealership(dealerParts[0].trim(), dealerParts[1].trim(), dealerParts[2].trim());

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length < 8) continue;

                int vin = Integer.parseInt(parts[0].trim());
                int year = Integer.parseInt(parts[1].trim());
                String make = parts[2].trim();
                String model = parts[3].trim();
                String type = parts[4].trim();
                String color = parts[5].trim();
                int odometer = Integer.parseInt(parts[6].trim());
                double price = Double.parseDouble(parts[7].trim());

                dealership.addVehicle(new Vehicle(vin, year, make, model, type, color, odometer, price));
            }

            System.out.println("Loaded " + dealership.getAllVehicles().size() + " vehicles from " + FILE_NAME);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            dealership = new Dealership("Unnamed Dealership", "Unknown Address", "000-000-0000");
        }

        return dealership;
    }


    public void saveDealership(Dealership dealership) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine();

            for (Vehicle v : dealership.getAllVehicles()) {
                writer.write(v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|" +
                        v.getModel() + "|" + v.getType() + "|" + v.getColor() + "|" +
                        v.getOdometer() + "|" + v.getPrice());
                writer.newLine();
            }

            System.out.println("Saved " + dealership.getAllVehicles().size() + " vehicles to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
