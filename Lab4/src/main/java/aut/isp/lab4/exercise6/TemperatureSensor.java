package aut.isp.lab4.exercise6;

public class TemperatureSensor extends Sensor {
    public int value;
    public TemperatureSensor(String manufacturer, String model) {
        super(manufacturer, model);
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
