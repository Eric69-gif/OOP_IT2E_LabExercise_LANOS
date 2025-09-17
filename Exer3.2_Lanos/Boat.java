package Tranportation;

public class Boat extends WaterTransport {
    double length;
    String material;

    public Boat(String brand, int capacity, double speed, String hullType, double displacement,
                double length, String material) {
        super(brand, capacity, speed, hullType, displacement);
        this.length = length;
        this.material = material;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Length: " + length + " m, Material: " + material);
    }
}