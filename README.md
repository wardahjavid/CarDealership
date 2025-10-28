## Car Dealership Console Application

Description of the Project

This Java console application simulates a used car dealership management system.
It allows users to search, view, add, and remove vehicles from a dealership’s inventory.
The application loads data from a pipe-delimited CSV file (dealership.csv) that stores dealership information and all vehicle details such as VIN, year, make, model, type, color, odometer, and price.
Its purpose is to help dealership employees manage inventory efficiently without needing a graphical interface.
The intended users are dealership staff or sales representatives who need quick access to inventory data.
The main functionality includes searching vehicles by multiple filters (price, make/model, year, color, mileage, and type), viewing all inventory, and saving updates back to the CSV file automatically.
This project solves the problem of manual record-keeping by digitizing dealership inventory in a simple, text-based interface.

User Stories

As a user, I want to be able to load all dealership data from a file, so that I can view and search vehicles.
As a user, I want to find vehicles by price range, so that I can offer cars that fit a customer’s budget.
As a user, I want to search by make and model, so that I can quickly locate specific vehicles.
As a user, I want to filter vehicles by year, color, mileage, or type, so that I can meet customer preferences.
As a user, I want to add a new vehicle, so that new arrivals are immediately added to the dealership’s records.
As a user, I want to remove a sold vehicle, so that the inventory file remains accurate.
As a user, I want all data to be saved automatically to the CSV file, so that no information is lost.
As a user, I want to be able to input my data, so that the application can process it accordingly.
As a user, I want to receive immediate feedback, so I can understand what to do next.

Setup
Instructions on how to set up and run the project using IntelliJ IDEA
Prerequisites

IntelliJ IDEA: Ensure you have IntelliJ IDEA installed, which you can download from JetBrains IntelliJ IDEA
.

Java SDK: Make sure Java SDK (version 17 or later) is installed and configured in IntelliJ.

Running the Application in IntelliJ

Open IntelliJ IDEA.

Select "Open" and navigate to the directory where you cloned or downloaded the project.

After the project opens, wait for IntelliJ to index the files and set up the project.

Make sure dealership.csv is located in the project root directory (same level as the src folder).

Find the main class located at src/com/pluralsight/Main.java which contains the public static void main(String[] args) method.

Right-click on the Main.java file and select 'Run 'Main.main()' to start the application.

Technologies Used

Java: Version 17

IDE: IntelliJ IDEA Community Edition 2025.2

Data Storage: Pipe-delimited CSV file (dealership.csv) for persistent data storage

Libraries: No external libraries used — entirely built with core Java (java.io, java.util, java.time)

Demo
Application Screenshot

(You can include a screenshot or GIF here later)

Example Output:

=== DEALERSHIP MENU ===
1 - Find vehicles by price
2 - Find vehicles by make/model
3 - Find vehicles by year range
4 - Find vehicles by color
5 - Find vehicles by mileage
6 - Find vehicles by type
7 - List all vehicles
8 - Add a vehicle
9 - Remove a vehicle
99 - Quit


When “7” is selected:

--- CURRENT VEHICLE INVENTORY ---
VIN      YEAR   MAKE         MODEL        TYPE       COLOR      ODOMETER  PRICE
--------------------------------------------------------------------------------
10112    1993   Ford         Explorer     SUV        Red        525123    $995.00
37846    2001   Ford         Ranger       Truck      Yellow     172544    $1995.00
44901    2012   Honda        Civic        SUV        Gray       103221    $6995.00
50000    2021   Toyota       Camry        Sedan      Silver     12000     $24999.99

Future Work

Add input validation for better error handling.

Implement sorting features (e.g., sort by price or year).

Add a search history or reporting system (e.g., total inventory value).

Create a graphical user interface (GUI) using JavaFX or Swing.

Integrate with a database (e.g., MySQL) for more advanced data management.

Resources

Java Programming Tutorial – Oracle Java Documentation

Effective Java by Joshua Bloch

Pluralsight Course: Java Fundamentals – Capstone Workshop

IntelliJ IDEA User Guide

Team Members

Jenny Hawk – Developer and project lead, responsible for coding, debugging, and testing all classes (Main, UserInterface, Dealership, DealershipFileManager, and Vehicle).

Thanks

Thank you to the Pluralsight instructors for structured lessons and project guidance.
A special thanks to mentors and peers for support and feedback throughout the capstone workshop.
