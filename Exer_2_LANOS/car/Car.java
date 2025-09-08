public class Car {
    // Instance variables with private access modifier for encapsulation
    private String color;
    private String plateNo;
    private String chassisNo;
    private String carType;
    private String brand;
    // No-argument constructor

    public Car(String yellow, String kaW12345, String aB123) {
        this.color = "No Color";

        this.plateNo = "No PlateNumber";
        this.chassisNo = "No Chassis No Yet!";
        this.carType = " No Cartype ";
        this.brand = " No Brand ";
    }

    // Parameterized constructor
    public Car(String color, String plateNo, String chassisNo, String carType, String brand) {
        this.color = color;
        this.plateNo = plateNo;
        this.chassisNo = chassisNo;
        this.carType = carType;
        this.brand = brand;
    }
    

    public String displayInfo(){
        String info = "";
        info += "Color: " + this.color;
        info += "\nPlateNo: " + this.plateNo;
        info += "\nChassisNo: " + this.chassisNo;
        info += "\ncarType: " + this.carType;
        info += "\nbrand: " + this.brand;
        System.out.println(info+ "\n");
        return info;
    }
}
