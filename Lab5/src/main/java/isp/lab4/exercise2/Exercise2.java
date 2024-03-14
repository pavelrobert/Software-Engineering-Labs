package isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        SmartWatch smartwatch = new SmartWatch(20);
        SmartPhone smartphone = new SmartPhone(20);
        Laptop laptop = new Laptop(20);

        System.out.println("SmartWatch battery level: " + smartwatch.getBatteryLevel() + "%");
        System.out.println("SmartPhone battery level: " + smartphone.getBatteryLevel() + "%");
        System.out.println("Laptop battery level: " + laptop.getBatteryLevel() + "%");

        // charge for 30 minutes
        smartwatch.charge(20);
        smartphone.charge(20);
        laptop.charge(20);

        System.out.println("SmartWatch battery level: " + smartwatch.getBatteryLevel() + "%");
        System.out.println("SmartPhone battery level: " + smartphone.getBatteryLevel() + "%");
        System.out.println("Laptop battery level: " + laptop.getBatteryLevel() + "%");
    }
}
