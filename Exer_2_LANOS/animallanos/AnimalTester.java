public class AnimalTester {
    public static void main(String[] args) {
        // Using parameterized constructor with specific animal details
        Animal a1 = new Animal("cat", "lanos", "kabang", "balay sig katug", "Carnivore");

        // Using no-argument constructor (this will use default values)
        Animal a2 = new Animal();  // This will use default values

        // Display information for both animals
        a1.displayInfo();
        a2.displayInfo();
    }
}
