package aut.isp.lab4.exercise6;

import aut.isp.lab4.exercise5.Sensor;

public class phMonitoring extends Sensor {
    private float value;
    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }
    public phMonitoring(String manufacturer, String model) {
        super(manufacturer, model);
    }
}
