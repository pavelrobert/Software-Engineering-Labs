package isp.lab8.airways;

public class LessWaypoints extends Exception{
    private String mesage;
    public LessWaypoints(String mesage)
    {
        super(mesage);
    }
}
