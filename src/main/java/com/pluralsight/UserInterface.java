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


    private void processAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    // Placeholder methods for later phases
    private void processGetByPrice() {
        System.out.println(YELLOW + "The search by price has not been implemented yet." + RESET);
    }

    private void processGetByMakeModel() {
        System.out.println(YELLOW + "The search by make/model has not been implemented yet." + RESET);
    }

    private void processGetByYear() {
        System.out.println(YELLOW + "The search by year has not been implemented yet." + RESET);
    }

    private void processGetByColor() {
        System.out.println(YELLOW + "The search by color has not been implemented yet." + RESET);
    }

    private void processGetByMileage() {
        System.out.println(YELLOW + "The search by mileage has not implemented yet." + RESET);
    }

    private void processGetByType() {
        System.out.println(YELLOW + "The search by type has not implemented yet." + RESET);
    }

    private void processAddVehicle() {
        System.out.println(YELLOW + "The method Add vehicle has been not implemented yet." + RESET);
    }

    private void processRemoveVehicle() {
        System.out.println(YELLOW + "The method Remove vehicle has not been implemented yet." + RESET);
    }

}

