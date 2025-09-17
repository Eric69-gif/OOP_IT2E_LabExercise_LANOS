package Tranportation;

public class LandTransport extends Transportation {
    String fuelType;
    int wheels;

    public LandTransport(String brand, int capacity, double speed, String fuelType, int wheels) {
        super(brand, capacity, speed);
        this.fuelType = fuelType;
        this.wheels = wheels;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fuel Type: " + fuelType + ", Wheels: " + wheels);
    }
}