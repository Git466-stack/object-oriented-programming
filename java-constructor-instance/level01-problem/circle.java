class Circle {
    // Instance variable
    private double radius;

    // Default constructor
    public Circle() {
        this(1.0); // Calls the parameterized constructor with a default value of 1.0
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate the area of the circle
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to display circle details
    public void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
    }

    // Main method for testing
    public static void main(String[] args) {
        // Using default constructor
        Circle defaultCircle = new Circle();
        System.out.println("Default Circle Details:");
        defaultCircle.displayDetails();

        System.out.println();

        // Using parameterized constructor
        Circle parameterizedCircle = new Circle(5.0);
        System.out.println("Parameterized Circle Details:");
        parameterizedCircle.displayDetails();
    }
}
