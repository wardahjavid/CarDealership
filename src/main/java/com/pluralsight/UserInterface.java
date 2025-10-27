package com.pluralsight;

public class UserInterface {
    private Dealership dealership;
    public void display() {
        DealershipFileManager dfm = new DealershipFileManager();
        this.dealership = dfm.getDealership();
    }

}
