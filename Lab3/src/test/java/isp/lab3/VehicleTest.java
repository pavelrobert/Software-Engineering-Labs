package isp.lab3;
import isp.lab3.exercise3.Vehicle;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {
    @Test
    public void testToString(){
        Vehicle vehicle1 = new Vehicle("Dacia", "Logan", 180, 'D');
        Vehicle vehicle2 = new Vehicle("Skoda", "Octavia", 200, 'D');

        System.out.println(vehicle1.toString());
        System.out.println(vehicle2.toString());
    }
}
