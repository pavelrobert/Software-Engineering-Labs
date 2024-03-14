package aut.isp.lab4.exercise6;

public class Alarm extends Actuator {
    public Alarm(String manufacturer, String model) {
        super(manufacturer, model);
    }
    public void turnOn(){
        System.out.println("The alarm is on!");
    }
    public void turnOff(){
        System.out.println("The alarm is off!");
    }
}

