package isp.lab3;
import isp.lab3.exercise4.MyPoint;
import org.junit.Test;

import static java.lang.Math.sqrt;
import static org.junit.Assert.*;

public class MyPointTest {
    @Test
    public void testDistance() {
        MyPoint p1 = new MyPoint(3, 3, 3);
        MyPoint p2 = new MyPoint(2, 2, 2);

        float a = (float) sqrt(3);
        double distance = p1.distance(p2);
        assertEquals(a, distance, 0.00001);
    }
}
