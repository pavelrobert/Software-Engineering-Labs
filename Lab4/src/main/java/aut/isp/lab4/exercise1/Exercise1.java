package aut.isp.lab4.exercise1;
import aut.isp.lab4.exercise2.FishFeeder;
import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        //create an object
        AquariumController controller1 = new AquariumController("Bosch", "L9");
        controller1.setCurrentTime(13.22f);
        System.out.println(controller1.toString());
    }
}
