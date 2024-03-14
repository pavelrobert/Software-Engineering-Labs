package isp.lab4.exercise2;

public class SmartPhone implements Chargeable {
    private int batteryLevel = 0;
    private int chargingSpeed = 2;
    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }
    public void setBatteryLevel(int batteryLevel){
        this.batteryLevel = batteryLevel;
    }
    SmartPhone(int batteryLevel){
        this.batteryLevel = batteryLevel;
    }
    @Override
    public void showBatteryLevel() {
        System.out.println("Battery at: "+batteryLevel+"%");
    }
    @Override
    public void charge(int durationInMinutes) {
        int chargedLevel = durationInMinutes / 2 * chargingSpeed;
        batteryLevel = Math.min(batteryLevel + chargedLevel, 100);
    }
}
