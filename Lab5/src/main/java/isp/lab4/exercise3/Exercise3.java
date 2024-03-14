package isp.lab4.exercise3;
import java.util.ArrayList;
import java.util.List;
public class Exercise3 {
    public static void main(String[] args) {
        List<TemperatureSensor> tempSensors = new ArrayList<>();
        List<PressureSensor> pressSensors = new ArrayList<>();

        pressSensors.add(new PressureSensor(20,"Arduino project","Humidity Sensor"));
        pressSensors.add(new PressureSensor(80,"Arduino UNO project","Pressure Sensor"));
        pressSensors.add(new PressureSensor(150,"Faculty","Pressure Sensor"));
        pressSensors.add(new PressureSensor(260,"Home","Pressure Sensor"));
        pressSensors.add(new PressureSensor(0,"Aquarium","Humidity Sensor"));
        pressSensors.add(new PressureSensor(15,"University","Pressure Sensor"));

        tempSensors.add(new TemperatureSensor(35,"Bedroom","Temp Sensor"));
        tempSensors.add(new TemperatureSensor(0,"Inside","Mid-Temp Sensor"));
        tempSensors.add(new TemperatureSensor(100,"Kitchen","High-Temp Sensor"));
        tempSensors.add(new TemperatureSensor(25,"Outside","Mid-Tier Temp Sensor"));

        MonitoringService ms = new MonitoringService(tempSensors, pressSensors);

        System.out.println("The average temperature from the temperature sensors is: " + ms.getAverageTemperatureSensors());
        System.out.println("The average value from all sensors is: " + ms.getAverageAllSensors());
    }
}
