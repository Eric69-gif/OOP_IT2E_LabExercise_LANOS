package Tranportation;

public class Helicopter extends AirTransport {
    String rotorType;
    int bladeCount;

    public Helicopter(String brand, int capacity, double speed, double altitude, int engineCount,
                      String rotorType, int bladeCount) {
        super(brand, capacity, speed, altitude, engineCount);
        this.rotorType = rotorType;
        this.bladeCount = bladeCount;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Rotor Type: " + rotorType + ", Blades: " + bladeCount);
    }
}