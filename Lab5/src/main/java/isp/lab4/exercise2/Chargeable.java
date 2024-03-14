package isp.lab4.exercise2;

/**
 * @author Radu Miron
 */
public interface Chargeable {
    public int getBatteryLevel();
    public void showBatteryLevel();
    public void charge(int durationInMinutes);
}
