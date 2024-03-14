package aut.isp.lab4.exercise6;

import aut.isp.lab4.exercise3.FishFeeder;
import aut.isp.lab4.exercise5.Heater;
import aut.isp.lab4.exercise5.LevelSensor;
import aut.isp.lab4.exercise6.phMonitoring;
public class AquariumController {

    private FishFeeder feeder;
    private String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;
    private int presentTemperature;
    private float presentLevel;
    private float lightsOnTime;
    private float lightOffTime;
    private int temperature;
    private int waterLevel;
    private LevelSensor levelSensor;
    private Alarm alarm;
    private Heater heater;
    private phMonitoring phMonitor;
    private float phLevel;

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
    }
    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
    }
    public void setLightsOnTime(float lightsOnTime) {
        this.lightsOnTime = lightsOnTime;
    }
    public void setLightOffTime(float lightOffTime) {
        this.lightOffTime = lightOffTime;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public void setPhLevel(float phLevel) {
        this.phLevel = phLevel;
    }

    public int getWaterLevel() {
        return waterLevel;
    }
    public float getFeedingTime() {
        return feedingTime;
    }
    public float getLightsOnTime() {
        return lightsOnTime;
    }
    public float getLightOffTime() {
        return lightOffTime;
    }
    public int getTemperature() {
        return temperature;
    }
    public float getPhLevel() {
        return phLevel;
    }
    public AquariumController(String manufacturer, String model, float currentTime, FishFeeder feeder, Heater heater, Alarm alarm, phMonitoring monitor){
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feeder = feeder;
        this.heater = heater;
        this.alarm = alarm;
        this.phMonitor = monitor;
    }
    public void checkWaterLevel(int waterLevel){
        if(waterLevel < this.waterLevel)
            alarm.turnOn();
    }
    public void checkTemperature(int temperatureLevel){
        if(temperatureLevel < temperature)
            heater.turnOn();
        if(temperatureLevel == temperature)
            heater.turnOff();
    }

    public void checkPh(float currentPhLevel){
        if(currentPhLevel <= phLevel){
            System.out.println("If we change the monitor the fish will be alive!");
        }
        else
        {
            System.out.println("If we change the monitor the fish will not be alive!");
        }
    }
    @Override
    public String toString(){
        return "AquariumController{model = " + model + ", manufacturer " + manufacturer + ", currentTime " + currentTime;
    }
}
