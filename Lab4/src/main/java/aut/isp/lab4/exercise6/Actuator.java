package aut.isp.lab4.exercise6;

public abstract class Actuator {
    private String manufacturer;
    private String model;
    public Actuator(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }
    public void turnOn(){
        System.out.println("The actuator is on!");
    }
    public void turnOff(){
        System.out.println("The actuator is off!");
    }
    @Override
    public String toString(){
        return "Actuator{model= " + model + " manufacturer= " + manufacturer;
    }
}
