package Tranportation;

public class Tricycle extends LandTransport {
    double fare;
    int passengerCount;

    public Tricycle(String brand, int capacity, double speed, String fuelType, int wheels,
                    double fare, int passengerCount) {
        super(brand, capacity, speed, fuelType, wheels);
        this.fare = fare;
        this.passengerCount = passengerCount;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fare: " + fare + " PHP, Passengers: " + passengerCount);
    }
}