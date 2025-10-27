package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

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
                    displayVehicles(dealership.getAllVehicles());
                    break;
                case "8":
                    processAddVehicle();
                    break;
                case "9":
                    processRemoveVehicle();
                    break;
                case "99":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("This is an invalid choice.");
                    break;
            }
        }
    }
    private void displayMenu() {
        System.out.println("\n=== DEALERSHIP MENU ===");
        System.out.println("1 - Find vehicles by price");
        System.out.println("2 - Find vehicles by make/model");
        System.out.println("3 - Find vehicles by year range");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage");
        System.out.println("6 - Find vehicles by type");
        System.out.println("7 - List all vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");
        System.out.print("Enter your choice: ");
    }
    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }























































    private void displayMenu() {
        System.out.println("\n=== DEALERSHIP MENU ===");
        System.out.println("1 - Find vehicles by price");
        System.out.println("2 - Find vehicles by make/model");
        System.out.println("3 - Find vehicles by year range");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage");
        System.out.println("6 - Find vehicles by type");
        System.out.println("7 - List all vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");
        System.out.print("Enter your choice: ");
}

}
