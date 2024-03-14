package aut.isp.lab4.exercise5;

import aut.isp.lab4.exercise3.FishFeeder;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        AquariumController controller = new AquariumController("Bosch","Big Tank",10.30f,new FishFeeder("Cat","Blue"), new Heater("Bosch", "Heater"), new Alarm("Bosch", "Alarm"));

        System.out.println("Enter the preset temperature: ");
        Scanner sc = new Scanner(System.in);
        int temperature = sc.nextInt();
        controller.setTemperature(temperature);

        System.out.println("Enter the preset water level: ");
        int waterLevel = sc.nextInt();
        controller.setWaterLevel(waterLevel);

        while(true){
            System.out.println("Enter the current temperature: ");
            int temperatureCurrent = sc.nextInt();

            System.out.println("Enter the current water level: ");
            int waterLevelCurrent = sc.nextInt();

            controller.checkTemperature(temperatureCurrent);
            controller.checkWaterLevel(waterLevelCurrent);
            break;
        }
    }
}
