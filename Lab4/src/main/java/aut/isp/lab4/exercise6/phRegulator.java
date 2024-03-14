package aut.isp.lab4.exercise6;

import aut.isp.lab4.exercise6.Actuator;

public class phRegulator extends Actuator {
    public phRegulator(String manufacturer, String model) {
        super(manufacturer, model);
    }

    public void turnOn(){
        System.out.println("ph levels too high!!!");
    }
    public void turnOff(){
        System.out.println("ph level normal");
    }
}