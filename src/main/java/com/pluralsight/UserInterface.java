package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    public void display() {
        DealershipFileManager dfm = new DealershipFileManager();
        this.dealership = dfm.getDealership();

        Scanner potatoscanner = new Scanner(System.in);
        String choice = "";
    }

}
