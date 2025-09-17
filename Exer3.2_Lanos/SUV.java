package Tranportation;

public class SUV extends LandTransport {
    String luxuryLevel;
    double groundClearance;

    public SUV(String brand, int capacity, double speed, String fuelType, int wheels,
               String luxuryLevel, double groundClearance) {
        super(brand, capacity, speed, fuelType, wheels);
        this.luxuryLevel = luxuryLevel;
        this.groundClearance = groundClearance;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Luxury Level: " + luxuryLevel + ", Ground Clearance: " + groundClearance + " inches");
    }
}