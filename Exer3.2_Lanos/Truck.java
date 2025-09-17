package Tranportation;

public class Truck extends LandTransport {
    double cargoLoad;
    double maxLoad;

    public Truck(String brand, int capacity, double speed, String fuelType, int wheels,
                 double cargoLoad, double maxLoad) {
        super(brand, capacity, speed, fuelType, wheels);
        this.cargoLoad = cargoLoad;
        this.maxLoad = maxLoad;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Cargo Load: " + cargoLoad + " tons, Max Load: " + maxLoad + " tons");
    }
}