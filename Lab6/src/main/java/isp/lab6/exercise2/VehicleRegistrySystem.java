package isp.lab6.exercise2;

import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class VehicleRegistrySystem {

    private Set<Vehicle> vehicles = new HashSet<>();

    public void addVehicle(Vehicle vehicle) {
        if (!vehicles.contains(vehicle)) {
            vehicles.add(vehicle);
            System.out.println("Vehicle added to registry.");
        } else {
            System.out.println("Vehicle with VIN " + vehicle.getVin() + " already exists in registry.");
        }
    }


    public void removeVehicle(String vin) {
        Vehicle vehicle = new Vehicle(vin, null, null, null, 0);
        if (vehicles.remove(vehicle)) {
            System.out.println("Vehicle with VIN " + vin + " removed from registry.");
        } else {
            System.out.println("Vehicle with VIN " + vin + " not found in registry.");
        }
    }

    public boolean containsVehicle(String vin) {
        Vehicle vehicle = new Vehicle(vin, null, null, null, 0);
        return vehicles.contains(vehicle);
    }

    public void displayVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in registry.");
        } else {
            System.out.println("Vehicle Registry:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle.toString());
            }
        }
    }
    public void searchVehicle(String vin) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin().equals(vin)) {
                System.out.println("Vehicle found in registry:");
                System.out.println(vehicle.toString());
                return;
            }
        }
        System.out.println("Vehicle with VIN " + vin + " not found in registry.");
    }
}