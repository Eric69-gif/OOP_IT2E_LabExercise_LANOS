package Tranportation;

public class Ship extends WaterTransport {
    int crewSize;
    int deckCount;

    public Ship(String brand, int capacity, double speed, String hullType, double displacement,
                int crewSize, int deckCount) {
        super(brand, capacity, speed, hullType, displacement);
        this.crewSize = crewSize;
        this.deckCount = deckCount;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Crew Size: " + crewSize + ", Deck Count: " + deckCount);
    }
}