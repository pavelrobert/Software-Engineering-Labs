package isp.lab6.exercise2;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleRegistrySystem registry = new VehicleRegistrySystem();

        while (true) {
            System.out.println("Choose an option from the manu by inputting its index\n");
            System.out.println("1. Add vehicle to registry");
            System.out.println("2. Remove vehicle from registry");
            System.out.println("3. Search for vehicle in registry");
            System.out.println("4. Display all vehicles in registry");
            System.out.println("5. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:

                    System.out.println("Enter license plate:");
                    String licensePlate = scanner.next();
                    System.out.println("Enter make:");
                    String make = scanner.next();
                    System.out.println("Enter model:");
                    String model = scanner.next();
                    System.out.println("Enter year:");
                    int year = scanner.nextInt();
                    System.out.println("Enter VIN:");
                    String vin = scanner.next();

                    Vehicle vehicle = new Vehicle(vin, licensePlate, make, model, year);
                    registry.addVehicle(vehicle);
                    break;
                case 2:
                    System.out.println("Enter VIN:");
                    vin = scanner.next();
                    registry.removeVehicle(vin);
                    break;
                case 3:
                    System.out.println("Enter VIN:");
                    vin = scanner.next();
                    registry.searchVehicle(vin);
                    break;
                case 4:
                    registry.displayVehicles();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }
}
