package aut.isp.lab4.exercise4;

import aut.isp.lab4.exercise1.AquariumController;

public class FishFeeder extends AquariumController{
    private String manufacturer;
    private String model;
    private int meals;
    private float currentTime;
    private float feedingTime;


    public FishFeeder(String manufacturer, String model) {
        super(manufacturer, model);
        this.manufacturer = manufacturer;
        this.model = model;
    }
    public void fillUp() {
        this.meals = 14;
        System.out.println("Meals refreshed");
    }
    public void feed() {
        while (this.meals > 0) {
            System.out.println("No. of remaining meals: " + this.meals);
            this.meals--;
        }
        System.out.println("Out of food");
    }

    @Override
    public String toString() {
        return "Fish feeder: " + this.manufacturer + " - " + this.model + " - " + this.meals + "no. of meals";
    }
}
