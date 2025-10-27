package com.pluralsight;

import java.io.*;

public class DealershipFileManager {
    public Dealership getDealership() {
        Dealership dealership = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {
            String firstLine = reader.readLine();
            String[] dealerParts = firstLine.split("\\|");
            dealership = new Dealership(dealerParts[0], dealerParts[1], dealerParts[2]);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                int vin = Integer.parseInt(data[0]);
                int year = Integer.parseInt(data[1]);
                String make = data[2];
                String model = data[3];
                String type = data[4];
                String color = data[5];
                int odometer = Integer.parseInt(data[6]);
                double price = Double.parseDouble(data[7]);
                Vehicle v = new Vehicle(vin, year, make, model, type, color, odometer, price);
                dealership.addVehicle(v);
            }
        } catch (Exception e) {
            System.out.println("There is error loading the inventory file.");
        }
        return dealership;
    }
    public void saveDealership(Dealership dealership) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv"))) {
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine();
            for (Vehicle v : dealership.getAllVehicles()) {
                writer.write(v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|" + v.getModel() + "|" +
                        v.getType() + "|" + v.getColor() + "|" + v.getOdometer() + "|" + v.getPrice());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("There is an error saving the inventory files.");
        }
    }
}
