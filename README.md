## Car Dealership Console Application

### Description of the Project

This Java console application simulates a used car dealership management system. It allows users to search, view, add, and remove vehicles from a dealership’s inventory. 
The application loads data from the Dealiership.csv file that stores dealership information and all vehicle details such as VIN, year, make, model, type, color, odometer, and price. Its purpose is to help dealership employees manage inventory efficiently without needing a graphical interface. The intended users are dealership staff or sales representatives who need quick access to inventory data. 
The main functionality includes searching vehicles by multiple filters (price, make/model, year, color, mileage, and type), viewing all inventory, and saving updates back to the CSV file automatically. This project solves the problem of manual record-keeping by digitizing dealership inventory in a simple, text-based interface.

### User Stories

- As a user, I want to be able to load all dealership data from a file, so that I can view and search vehicles.
- As a user, I want to find vehicles by price range, so that I can offer cars that fit a customer’s budget.
- As a user, I want to search by make and model, so that I can quickly locate specific vehicles.
- As a user, I want to filter vehicles by year, color, mileage, or type, so that I can meet customer preferences.
- As a user, I want to add a new vehicle, so that new arrivals are immediately added to the dealership’s records.
- As a user, I want to remove a sold vehicle, so that the inventory file remains accurate.
- As a user, I want all data to be saved automatically to the CSV file, so that no information is lost.
- As a user, I want to be able to input my data, so that the application can process it accordingly.
- As a user, I want to receive immediate feedback, so I can understand what to do next.

### Setup
Instructions on how to set up and run the project using IntelliJ IDEA.

#### Prerequisites
- IntelliJ IDEA: Ensure you have IntelliJ IDEA installed, which you can download from here.
- Java SDK: Make sure Java SDK is installed and configured in IntelliJ.
  
#### Running the Application in IntelliJ
Follow these steps to get your application running within IntelliJ IDEA:
1. Open IntelliJ IDEA.
2. Select "Open" and navigate to the directory where you cloned or downloaded the project.
3. After the project opens, wait for IntelliJ to index the files and set up the project.
4. Find the main class with the `public static void main(String[] args)` method.
5. Right-click on the file and select 'Run 'YourMainClassName.main()'' to start the application.
