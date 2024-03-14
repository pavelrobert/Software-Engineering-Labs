package aut.isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        FishFeeder feeder = new FishFeeder("Cat","L9");
        feeder.fillUp();
        feeder.feed();
        feeder.feed();
        System.out.println(feeder.toString());
    }
}