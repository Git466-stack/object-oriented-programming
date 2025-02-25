// Circle.java
class Circle {
    // Attribute
    private double radius;

    // Constructor to initialize the Circle object
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate the area of the circle
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate the circumference of the circle
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display the area and circumference
    public void displayDetails() {
        System.out.println("Circle Details:");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }
}


public class Aoc {
    public static void main(String[] args) {
        // Create a Circle object
        Circle circle1 = new Circle(5.0); // Example radius: 5.0

        // Display the area and circumference of the circle
        circle1.displayDetails();
    }
}
