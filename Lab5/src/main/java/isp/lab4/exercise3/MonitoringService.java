package isp.lab4.exercise3;
import java.util.*;
public class MonitoringService {
    private List<TemperatureSensor> tempSensors;
    private List<PressureSensor> pressSensors;


    public MonitoringService(List<TemperatureSensor> tempSensors, List<PressureSensor> pressSensors)
    {
        this.tempSensors = tempSensors;
        this.pressSensors = pressSensors;
    }

    public double getAverageTemperatureSensors()
    {
        double averageTemperature = 0;
        int sum = 0;
        int count = 0;
        for(TemperatureSensor t:tempSensors)
        {
            sum += t.getTemperature();
            count++;
        }
        averageTemperature = sum/count;
        return averageTemperature;
    }

    public double getAverageAllSensors()
    {
        int averageTemperature = 0;
        int sum = 0;
        int count = 0;
        int sum1 = 0;
        int count1 = 0;
        int sum2 = 0;
        int count2 =0;
        for(TemperatureSensor t:tempSensors)
        {
            sum1 += t.getTemperature();
            count1++;
        }
        for(PressureSensor p:pressSensors)
        {
            sum2 += p.getPressure();
            count2++;
        }
        sum = sum1 + sum2;
        count = count1 + count2;
        averageTemperature = sum/count;
        return averageTemperature;
    }
}
