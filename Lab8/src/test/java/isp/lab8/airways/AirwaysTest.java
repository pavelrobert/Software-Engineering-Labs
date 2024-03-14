package isp.lab8.airways;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AirwaysTest {

    @Test
    public void testGeters()
    {
        Waypoint Cluj = new Waypoint("Cluj",46.7712,23.6236,1000);
        assertEquals("Cluj",Cluj.getName());
        assertEquals(46.7712,Cluj.getLatitude(), 0.0f);
        assertEquals(23.6236,Cluj.getLongitude(), 0.0f);
        assertEquals(1000,Cluj.getAltitude());
    }

    @Test
    public void testSeters()
    {
        Waypoint Cluj = new Waypoint("Cluj",46.7712,23.6236,1000);
        Cluj.setAltitude(999);
        Cluj.setLatitude(20.99);
        Cluj.setLongitude(55.99);
        Cluj.setName("Cluj!");
        assertEquals("Cluj!",Cluj.getName());
        assertEquals(20.99,Cluj.getLatitude(), 0.0f);
        assertEquals(55.99,Cluj.getLongitude(), 0.0f);
        assertEquals(999,Cluj.getAltitude());
    }

    @Test
    public void testToString()
    {
        Waypoint Cluj = new Waypoint("Cluj",46.7712,23.6236,1000);
        String expected = "Cluj 46.7712 23.6236 1000";
        assertEquals(expected, Cluj.toString());
        Waypoint Bucuresti = new Waypoint("Bucuresti",44.4268,26.1025,1000);
        String expected1= "Bucuresti 44.4268 26.1025 1000";
        assertEquals(expected1,Bucuresti.toString());


    }
}
