package aut.isp.lab4.exercise6;

public class FishFeeder {
    private String manufacturer;
    private String model;
    private int meals;

    public FishFeeder(){
        this.meals = 0;
    }
    public void feed(){
        if (this.meals > 0) {
            this.meals--;
            System.out.println("A meal has been dispensed. " + this.meals + " meals left.");
        } else {
            System.out.println("No more meals left in the fish feeder.");
        }
    }
    public void fillUp(){
        this.meals = 14;
        System.out.println("The meals have been filled to 14");
    }

    @Override
    public String toString(){
        return "Meals remaining = " + meals;
    }

}
