package aut.isp.lab4.exercise5;

public class LevelSensor extends Sensor{
    private float value;
    public LevelSensor(String manufacturer, String model) {
        super(manufacturer, model);
    }
    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }
}
