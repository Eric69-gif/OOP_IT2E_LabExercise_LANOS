package Tranportation;

public class Transportation {
    String brand;
    int capacity;
    double speed;

    public Transportation(String brand, int capacity, double speed) {
        this.brand = brand;
        this.capacity = capacity;
        this.speed = speed;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Capacity: " + capacity + ", Speed: " + speed + " km/h");
    }
}