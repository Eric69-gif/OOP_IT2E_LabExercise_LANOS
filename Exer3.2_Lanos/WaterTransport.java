package Tranportation;

public class WaterTransport extends Transportation {
    String hullType;
    double displacement;

    public WaterTransport(String brand, int capacity, double speed, String hullType, double displacement) {
        super(brand, capacity, speed);
        this.hullType = hullType;
        this.displacement = displacement;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Hull Type: " + hullType + ", Displacement: " + displacement + " tons");
    }
}