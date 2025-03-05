class Employee {
    // Attributes
    public int employeeID;         
    protected String department;   
    private double salary;        

    // Constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to get salary
    public double getSalary() {
        return salary;
    }

    // Public method to set salary
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative.");
        }
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}

// Subclass to demonstrate access modifiers
class Manager extends Employee {
    private int teamSize; // Additional attribute for Manager

    // Constructor
    public Manager(int employeeID, String department, double salary, int teamSize) {
        super(employeeID, department, salary);
        this.teamSize = teamSize;
    }

    // Method to display manager details
    @Override
    public void displayEmployeeDetails() {
        System.out.println("Manager Details:");
        System.out.println("Employee ID: " + employeeID); // Public
        System.out.println("Department: " + department); // Protected
        System.out.println("Team Size: " + teamSize);
    }
}


public class employeerecords {
    public static void main(String[] args) {
        // Create an Employee object
        Employee employee = new Employee(101, "Finance", 50000.0);
        System.out.println("Employee Details:");
        employee.displayEmployeeDetails();
        System.out.println();

        // Modify and access salary
        System.out.println("Updating Salary...");
        employee.setSalary(55000.0);
        System.out.println("Updated Salary: $" + employee.getSalary());
        System.out.println();

        // Create a Manager object
        Manager manager = new Manager(201, "IT", 75000.0, 10);
        manager.displayEmployeeDetails();
    }
}
