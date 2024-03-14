package isp.lab8.airways;


/**
 * Example waypoint class which can be extended to be used in implementation of the exercise. Add constructor, getters, setters, etc.
 */
public class Waypoint {
    private int index;
    private String name;
    private double latitude;
    private double longitude;
    private int altitude;
    public Waypoint(String name, double latitude, double longitude, int altitude)
    {
        this.altitude = altitude;
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;

    }
    public Waypoint()
    {

    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public int getIndex() {
        return index;
    }

    public int getAltitude() {
        return altitude;
    }

    @Override
    public String toString()
    {

        return name+" "+latitude+" "+longitude+" "+altitude;
    }
}
