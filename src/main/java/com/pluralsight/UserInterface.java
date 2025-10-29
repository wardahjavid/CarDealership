package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String CYAN = "\u001B[36m";

    public void display() {
        DealershipFileManager dfm = new DealershipFileManager();
        this.dealership = dfm.getDealership();

        Scanner potatoscanner = new Scanner(System.in);
        String option = "";

        while (!option.equals("99")) {
            displayMenu();
            option = potatoscanner.nextLine();

            switch (option) {
                case "1":
                    processGetByPrice();
                    break;
                case "2":
                    processGetByMakeModel();
                    break;
                case "3":
                    processGetByYear();
                    break;
                case "4":
                    processGetByColor();
                    break;
                case "5":
                    processGetByMileage();
                    break;
                case "6":
                    processGetByType();
                    break;
                case "7":
                    processAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicle();
                    break;
                case "9":
                    processRemoveVehicle();
                    break;
                case "99":
                    System.out.println(GREEN + "Goodbye! Thank you for using the Dealership App." + RESET);
                    break;
                default:
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
                    break;
            }
        }
    }


    private void displayMenu() {
        System.out.println(BLUE + "\n=== DEALERSHIP MENU ===" + RESET);
        System.out.println(YELLOW + "1" + RESET + " - Find vehicles by price");
        System.out.println(YELLOW + "2" + RESET + " - Find vehicles by make/model");
        System.out.println(YELLOW + "3" + RESET + " - Find vehicles by year range");
        System.out.println(YELLOW + "4" + RESET + " - Find vehicles by color");
        System.out.println(YELLOW + "5" + RESET + " - Find vehicles by mileage");
        System.out.println(YELLOW + "6" + RESET + " - Find vehicles by type");
        System.out.println(YELLOW + "7" + RESET + " - List all vehicles");
        System.out.println(YELLOW + "8" + RESET + " - Add a vehicle");
        System.out.println(YELLOW + "9" + RESET + " - Remove a vehicle");
        System.out.println(RED + "99" + RESET + " - Quit");
        System.out.print(CYAN + "Enter your choice: " + RESET);
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println(RED + "There are no vehicles found." + RESET);
            return;
        }

        System.out.println(BLUE + "\n--- VEHICLE INVENTORY ---" + RESET);
        System.out.println("-------------------------------------------------------------------------------------------");

        // Table header
        System.out.printf(YELLOW + "%-8s %-6s %-10s %-12s %-10s %-10s %-10s %-10s" + RESET + "\n",
                "VIN", "YEAR", "MAKE", "MODEL", "TYPE", "COLOR", "ODOMETER", "PRICE");
        System.out.println("-------------------------------------------------------------------------------------------");

        boolean useGreen = true;

        for (Vehicle vehicle : vehicles) {
            String color = useGreen ? GREEN : CYAN;
            System.out.printf(color + "%-8d %-6d %-10s %-12s %-10s %-10s %-10d $%-10.2f" + RESET + "\n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice());
            useGreen = !useGreen; // flip color each line
        }

        System.out.println("-------------------------------------------------------------------------------------------");
    }


    private void processGetByPrice() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter minimum price: ");
            double min = input.nextDouble();
            System.out.print("Enter maximum price: ");
            double max = input.nextDouble();
            ArrayList<Vehicle> matches = dealership.getVehiclesByPrice(min, max);
            displayVehicles(matches);
        } catch (Exception e) {
            System.out.println(RED + "Error: Invalid price input." + RESET);
        }
    }

    private void processGetByMakeModel() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter make: ");
        String make = input.nextLine();
        System.out.print("Enter model: ");
        String model = input.nextLine();
        ArrayList<Vehicle> matches = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(matches);
    }

    private void processGetByYear() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter minimum year: ");
            int min = input.nextInt();
            System.out.print("Enter maximum year: ");
            int max = input.nextInt();
            ArrayList<Vehicle> matches = dealership.getVehiclesByYear(min, max);
            displayVehicles(matches);
        } catch (Exception e) {
            System.out.println(RED + "There is an error: Invalid year input. " + RESET);
        }
    }

    private void processGetByColor() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter color: ");
        String color = input.nextLine();
        ArrayList<Vehicle> matches = dealership.getVehiclesByColor(color);
        displayVehicles(matches);
    }
    private void processGetByMileage() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter minimum mileage: ");
            int min = input.nextInt();
            System.out.print("Enter maximum mileage: ");
            int max = input.nextInt();
            ArrayList<Vehicle> matches = dealership.getVehiclesByMileage(min, max);
            displayVehicles(matches);
        } catch (Exception e) {
            System.out.println(RED + "There is an error: Invalid mileage input." + RESET);
        }
    }
    private void processGetByType() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter type (SUV, Truck, Sedan, etc.): ");
        String type = input.nextLine();
        ArrayList<Vehicle> matches = dealership.getVehiclesByType(type);
        displayVehicles(matches);
    }

    private void processAllVehiclesRequest() {
        DealershipFileManager dfm = new DealershipFileManager();
        this.dealership = dfm.getDealership();

        ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();

        if (allVehicles.isEmpty()) {
            System.out.println("No vehicles found in inventory.");
        } else {
            System.out.println("\n--- CURRENT VEHICLE INVENTORY ---");
            System.out.printf("%-8s %-6s %-12s %-12s %-10s %-10s %-10s %-10s%n",
                    "VIN", "YEAR", "MAKE", "MODEL", "TYPE", "COLOR", "ODOMETER", "PRICE");
            System.out.println("--------------------------------------------------------------------------------");
            for (Vehicle v : allVehicles) {
                System.out.printf("%-8d %-6d %-12s %-12s %-10s %-10s %-10d $%.2f%n",
                        v.getVin(), v.getYear(), v.getMake(), v.getModel(),
                        v.getType(), v.getColor(), v.getOdometer(), v.getPrice());
            }
        }
    }


    private void processAddVehicle() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("VIN: ");
            int vin = input.nextInt();
            System.out.print("Year: ");
            int year = input.nextInt();
            input.nextLine(); // clear buffer
            System.out.print("Make: ");
            String make = input.nextLine();
            System.out.print("Model: ");
            String model = input.nextLine();
            System.out.print("Type: ");
            String type = input.nextLine();
            System.out.print("Color: ");
            String color = input.nextLine();
            System.out.print("Odometer: ");
            int odometer = input.nextInt();
            System.out.print("Price: ");
            double price = input.nextDouble();

            Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
            dealership.addVehicle(newVehicle);

            new DealershipFileManager().saveDealership(dealership);
            System.out.println("Vehicle added and saved to file!");
        } catch (Exception e) {
            System.out.println("Error adding vehicle: " + e.getMessage());
        }
    }
    private void processRemoveVehicle() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter VIN to remove: ");
            int vin = input.nextInt();

            dealership.removeVehicle(vin);
            new DealershipFileManager().saveDealership(dealership);
            System.out.println("Vehicle removed and file updated!");
        } catch (Exception e) {
            System.out.println("Error removing vehicle: " + e.getMessage());
        }
    }
}
