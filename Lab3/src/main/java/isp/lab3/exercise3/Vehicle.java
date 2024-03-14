package isp.lab3.exercise3;

public class Vehicle {
    private static int count; /* point 4 - variable to count the number of objects created */
    private String model;
    private String type;
    private int speed;
    private char fuelType;

    public Vehicle(String m, String t, int s, char f) {
        model = m;
        type = t;
        speed = s;
        fuelType = f;
        count++; /* point 4 */
    }

    public String getModel() {
        return model;
    }

    public void setModel(String newModel) {
        model = newModel;
    }

    public String getType() {
        return type;
    }

    public void setType(String newType) {
        type = newType;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }

    public char fuelType() {
        return fuelType;
    }

    public void setFuelType(char Type) {
        fuelType = Type;
    }

    public String toString() {
        return "Information:" + this.model + "(" + this.type + ")" + "speed" + this.speed + "fuel" + this.fuelType;
    }

    public static void DisplayNumVehicles() {
        System.out.println("The number of objects created is: " + count); /* point 4 */
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Vehicle)) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        return vehicle.getModel().equals(this.model) &&
                vehicle.getType().equals(this.type) &&
                vehicle.getSpeed() == (this.speed) &&
                vehicle.fuelType() == (this.fuelType);
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Dacia", "Logan", 180, 'D');
        Vehicle vehicle2 = new Vehicle("Dacia", "Logan", 180, 'D');

        System.out.println(vehicle1);
        System.out.println(vehicle2);

        if (vehicle1.equals(vehicle2)) {
            System.out.println("The two cars are equal");
        } else {
            System.out.println("The two cars are not equal");
        }
        Vehicle.DisplayNumVehicles();

    }
}
