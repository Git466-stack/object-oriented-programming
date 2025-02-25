// MobilePhone.java
class MobilePhone {
    // Attributes
    private String brand;
    private String model;
    private double price;

    // Constructor to initialize the MobilePhone object
    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display the details of the mobile phone
    public void displayDetails() {
        System.out.println("Mobile Phone Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: $" + price);
    }
}

// Main.java
public class MobilePhonedetails {
    public static void main(String[] args) {
        // Create a MobilePhone object
        MobilePhone phone1 = new MobilePhone("Samsung", "Galaxy S21", 799.99);

        // Display the details of the phone
        phone1.displayDetails();
    }
}
