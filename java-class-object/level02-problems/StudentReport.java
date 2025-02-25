// Student.java
class Student {
    // Attributes
    private String name;
    private int rollNumber;
    private double marks;

    // Constructor to initialize the Student object
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to calculate the grade based on marks
    public String calculateGrade() {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 80) {
            return "B";
        } else if (marks >= 70) {
            return "C";
        } else if (marks >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // Method to display the student's details and grade
    public void displayDetails() {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }
}


public class StudentReport {
    public static void main(String[] args) {
        // Create a Student object
        Student student1 = new Student("Alice Johnson", 101, 85.5);

        // Display the student's details and grade
        student1.displayDetails();
    }
}
