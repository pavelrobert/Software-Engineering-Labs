package aut.isp.lab4.exercise6;
import aut.isp.lab4.exercise6.Actuator;

public class Heater extends Actuator {
    public Heater(String manufacturer, String model) {
        super(manufacturer, model);
    }

    public void turnOn(){
        System.out.println("The heater is turned on!");
    }
    public void turnOff(){
        System.out.println("The heater is turned off!");
    }
}
