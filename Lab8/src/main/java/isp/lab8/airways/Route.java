package isp.lab8.airways;

import java.util.ArrayList;

public class Route {

    public ArrayList<Waypoint> route ;

    Route()
    {
        route = new ArrayList<>();

    }

    public  void displayRoute()
    {
        for(Waypoint r : route)
            System.out.println(r.toString());


    }

    public void calculateRoute()
    {   double total = 0;
        WaypointDistanceCalculator waypointDistanceCalculator = new WaypointDistanceCalculator();
        for(int i=0; i< route.size()-1; i++)
        {
            double distance = waypointDistanceCalculator.calculateDistance(route.get(i).getLatitude(),route.get(i).getLongitude(),route.get(i+1).getLatitude(),route.get(i+1).getLongitude());
            total += distance;


        }
        System.out.println(total);
    }
}

