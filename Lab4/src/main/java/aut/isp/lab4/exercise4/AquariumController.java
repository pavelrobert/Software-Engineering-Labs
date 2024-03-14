package aut.isp.lab4.exercise4;

import javax.swing.*;

public class AquariumController {

    //attributes
    private String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;
    private float presetTemperature = 15f;
    private float presetLevel = 10f;
    private float lightOnTime;
    private float lightOffTime;
    //constructors
    public AquariumController(String manufacturer, String model){
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public AquariumController(){

    }
    //methods
    public void setCurrentTime(float currentTime){
        this.currentTime = currentTime;
    }
    public void setFeedingTime(float feedingTime){
        this.feedingTime = feedingTime;
    }
    public float getCurrentTime(){
        return this.currentTime;
    }
    public float getFeedingTime(){
        return this.feedingTime;
    }
    public float checkTemperature(){
        return this.presetTemperature;
    }
    public float checkWaterLevel(){
        return this.presetLevel;
    }
    public void setLightOnTime(float lightOnTime){
        this.lightOnTime = lightOnTime;
    }
    public void setLightOffTime(float lightOffTime){
        this.lightOffTime = lightOffTime;
    }
    public float getLightOnTime(){
        return this.lightOnTime;
    }
    public float getLightOffTime(){
        return this.lightOffTime;
    }
    @Override
    public String toString(){
        return "Aquarium Controller: " + this.manufacturer + "- " + this.model + " - " + this.currentTime + " - " + this.feedingTime;
    }
}
