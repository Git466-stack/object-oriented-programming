// Employee.java
class Employee {
    // Attributes
    private String name;
    private int id;
    private double salary;

    // Constructor to initialize the Employee object
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

// Main.java
public class EmployeeDetails {
    public static void main(String[] args) {
        // Create an Employee object
        Employee employee1 = new Employee("John Doe", 101, 50000.0);

        // Display the details of the employee
        employee1.displayDetails();
    }
}
