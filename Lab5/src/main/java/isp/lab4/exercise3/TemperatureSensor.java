package isp.lab4.exercise3;

public class TemperatureSensor extends Sensor{
    private double temperature;
    public TemperatureSensor(double temperature,String installLocation, String name) {
        super(installLocation,name);
        this.temperature = temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getValue() {
        return temperature;
    }
}
