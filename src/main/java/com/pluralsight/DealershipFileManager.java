package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

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
}
