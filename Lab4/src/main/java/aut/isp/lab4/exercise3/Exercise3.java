package aut.isp.lab4.exercise3;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        FishFeeder feeder = new FishFeeder("LTD Aquarium","2187");
        AquariumController controller = new AquariumController(feeder, "Turquoise", "Cat", 13);
        feeder.fillUp();
        Scanner input = new Scanner(System.in);
        feeder.setCurrentTime(input.nextFloat());
        feeder.setFeedingTime(14.50f);
        float time = feeder.getCurrentTime();
        float feedTime = feeder.getFeedingTime();
        if(time == feedTime){
            feeder.feed();
        }
        System.out.println(feeder.toString());
    }
}
