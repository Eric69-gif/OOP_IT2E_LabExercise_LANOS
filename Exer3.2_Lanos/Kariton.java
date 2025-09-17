package Tranportation;

public class Kariton extends LandTransport {
    String material;
    boolean isAnimalDriven;

    public Kariton(String brand, int capacity, double speed, String fuelType, int wheels,
                   String material, boolean isAnimalDriven) {
        super(brand, capacity, speed, fuelType, wheels);
        this.material = material;
        this.isAnimalDriven = isAnimalDriven;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Material: " + material + ", Animal Driven: " + isAnimalDriven);
    }
}