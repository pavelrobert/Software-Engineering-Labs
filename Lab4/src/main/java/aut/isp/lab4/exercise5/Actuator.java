package aut.isp.lab4.exercise5;

import aut.isp.lab4.exercise1.AquariumController;

abstract class Actuator extends AquariumController {
    private String manufacturer;
    private String model;
    Actuator(String manufacturer,String model){
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public void turnOn(){
        System.out.println("Actuators activation");
    }

    public void turnOff(){
        System.out.println("Actuators deactivation");
    }

    @Override
    public String toString(){
        return this.manufacturer + " - " + this.model;
    }
}
