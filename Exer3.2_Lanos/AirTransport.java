package Tranportation;

public class AirTransport extends Transportation {
    double altitude;
    int engineCount;

    public AirTransport(String brand, int capacity, double speed, double altitude, int engineCount) {
        super(brand, capacity, speed);
        this.altitude = altitude;
        this.engineCount = engineCount;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Altitude: " + altitude + " m, Engine Count: " + engineCount);
    }
}