class CarRental {
    // Attributes
    private String customerName;
    private String carModel;
    private int rentalDays;
    private static final double DAILY_RENTAL_RATE = 50.0; // Daily rental cost in dollars

    // Default constructor
    public CarRental() {
        this.customerName = "Unknown Customer";
        this.carModel = "Unknown Car Model";
        this.rentalDays = 0;
    }

    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Method to calculate the total rental cost
    public double calculateTotalCost() {
        return rentalDays * DAILY_RENTAL_RATE;
    }

    // Method to display rental details
    public void displayRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }

    // Main method for testing
    public static void main(String[] args) {
        // Using default constructor
        CarRental defaultRental = new CarRental();
        System.out.println("Default Rental Details:");
        defaultRental.displayRentalDetails();

        System.out.println();

        // Using parameterized constructor
        CarRental customRental = new CarRental("John Doe", "Toyota Camry", 5);
        System.out.println("Custom Rental Details:");
        customRental.displayRentalDetails();
    }
}
