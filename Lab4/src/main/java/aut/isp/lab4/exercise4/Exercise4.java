package aut.isp.lab4.exercise4;

import aut.isp.lab4.exercise1.AquariumController;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        AquariumController lights = new AquariumController("LTD Aquariums", "2187");
        Scanner input = new Scanner(System.in);
        lights.setCurrentTime(input.nextFloat());
        float time = lights.getCurrentTime();
        lights.setLightOnTime(input.nextFloat());
        lights.setLightOffTime(input.nextFloat());
        while (time >= lights.getLightOnTime() && time < lights.getLightOffTime()){
            System.out.println("LIGHTS ON!");
            time++;
        }
        System.out.println("LIGHTS OFF!");
    }
}