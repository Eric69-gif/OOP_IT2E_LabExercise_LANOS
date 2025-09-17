package Tranportation;

public class Plane extends AirTransport {
    String airline;
    double range;

    public Plane(String brand, int capacity, double speed, double altitude, int engineCount,
                 String airline, double range) {
        super(brand, capacity, speed, altitude, engineCount);
        this.airline = airline;
        this.range = range;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Airline: " + airline + ", Range: " + range + " km");
    }
}