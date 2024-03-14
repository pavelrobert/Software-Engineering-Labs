package isp.lab4.exercise3;

public abstract class Sensor {
    private String installLocation;
    private String name;
    public Sensor(String installLocation, String name) {
        this.installLocation = installLocation;
        this.name = name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setInstallLocation(String installLocation){
        this.installLocation = installLocation;
    }

    public String getName() {
        return name;
    }

    public String getInstallLocation() {
        return installLocation;
    }
}
