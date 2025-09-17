package Tranportation;

public class Motorcycle extends LandTransport {
    int engineCC;
    String type;

    public Motorcycle(String brand, int capacity, double speed, String fuelType, int wheels,
                      int engineCC, String type) {
        super(brand, capacity, speed, fuelType, wheels);
        this.engineCC = engineCC;
        this.type = type;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Engine CC: " + engineCC + ", Type: " + type);
    }
}