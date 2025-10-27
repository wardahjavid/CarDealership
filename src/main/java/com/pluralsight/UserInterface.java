package com.pluralsight;

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
                case "1": processGetByPrice(); break;
                case "2": processGetByMakeModel(); break;
                case "3": processGetByYear(); break;
                case "4": processGetByColor(); break;
                case "5": processGetByMileage(); break;
                case "6": processGetByType(); break;
                case "7": displayVehicles(dealership.getAllVehicles()); break;
                case "8": processAddVehicle(); break;
                case "9": processRemoveVehicle(); break;
                case "99":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("This is an invalid choice.");
                    break;
            }
        }
    }

}
