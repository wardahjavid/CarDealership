package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, ArrayList<Vehicle> inventory, String address, String phone) {
        this.name = name;
        this.inventory = inventory;
        this.address = address;
        this.phone = phone;
    }
}
