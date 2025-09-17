package Tranportation;

public class TransportationTester {
    public static void main(String[] args) {
        // Air
        Plane plane = new Plane("Airbus", 300, 850, 12000, 2, "Philippine Airlines", 15000);
        Helicopter heli = new Helicopter("Bell", 5, 250, 3000, 1, "Single Rotor", 4);

        // Land
        Truck truck = new Truck("Isuzu", 3, 120, "Diesel", 6, 5, 10);
        SUV suv = new SUV("Toyota", 7, 180, "Gasoline", 4, "Luxury", 9.5);
        Tricycle tricycle = new Tricycle("Honda", 4, 60, "Gasoline", 3, 10, 3);
        Motorcycle moto = new Motorcycle("Kawasaki", 2, 180, "Gasoline", 2, 650, "Sport");
        Kariton kariton = new Kariton("Local", 2, 10, "None", 2, "Wood", true);

        // Water
        Ship ship = new Ship("Norwegian", 4000, 40, "Steel", 70000, 1500, 20);
        Boat boat = new Boat("Bangka", 20, 30, "Wood", 500, 12, "Bamboo");

        // Display
        System.out.println("\n--- Air Transport ---");
        plane.displayInfo();
        heli.displayInfo();

        System.out.println("\n--- Land Transport ---");
        truck.displayInfo();
        suv.displayInfo();
        tricycle.displayInfo();
        moto.displayInfo();
        kariton.displayInfo();

        System.out.println("\n--- Water Transport ---");
        ship.displayInfo();
        boat.displayInfo();
    }
}