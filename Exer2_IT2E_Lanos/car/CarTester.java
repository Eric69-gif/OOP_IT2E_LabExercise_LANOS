public class CarTester {
    public static void main(String[] args) {
        // Using parameterized constructor with correct string literals
        Car c1 = new Car("Yellow", "wyzas", "geswws", "Pickup", "Misubishi");

        
        // Using no-argument constructor
        Car c2 = new Car("Yellow", "wyzas", "geswws", "Pickup", "Misubishi"); // This will use the default values

        // Display information for both cars
        c1.displayInfo();

        c2.displayInfo();
    }
}
