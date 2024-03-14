package aut.isp.lab4.exercise6;

import aut.isp.lab4.exercise3.FishFeeder;
import aut.isp.lab4.exercise5.Heater;

import java.util.Scanner;
public class Exercise6 {
    public static void main(String[] args) {
        AquariumController controller = new AquariumController("Bosch","Big Tank",10.30f,new FishFeeder("Bosch", "Blue"), new Heater("Bosch", "Heater"), new Alarm("Bosch", "Alarm"),new phMonitoring("Bosch","phMonitor"));
        System.out.println("Enter the preset ph level: ");
        Scanner sc = new Scanner(System.in);
        int level = sc.nextInt();
        controller.setPhLevel(level);
        while(true)
        {
            System.out.println("Enter the current ph level: ");
            int phCurrent = sc.nextInt();
            controller.checkPh(phCurrent);
            break;
        }
    }
}
