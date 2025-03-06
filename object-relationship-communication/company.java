import java.util.ArrayList;

// Employee class
class Employee {
    private String name;
    private String position;

    // Constructor
    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    // Display employee details
    public void displayEmployeeDetails() {
        System.out.println("   Employee: " + name + ", Position: " + position);
    }
}

// Department class
class Department {
    private String name;
    private ArrayList<Employee> employees;

    // Constructor
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    // Getter for the department name
    public String getName() {
        return name;
    }

    // Add an employee to this department
    public void addEmployee(String name, String position) {
        employees.add(new Employee(name, position));
    }

    // Display department details
    public void displayDepartmentDetails() {
        System.out.println(" Department: " + name);
        if (employees.isEmpty()) {
            System.out.println("   No employees in this department.");
        } else {
            for (Employee employee : employees) {
                employee.displayEmployeeDetails();
            }
        }
    }

    // Clear employees (used during company deletion)
    public void clearEmployees() {
        employees.clear();
    }
}

// Company class
class Company {
    private String name;
    private ArrayList<Department> departments;

    // Constructor
    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    // Add a department to the company
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    // Add an employee to a specific department
    public void addEmployeeToDepartment(String departmentName, String employeeName, String position) {
        for (Department department : departments) {
            if (departmentName.equals(department.getName())) {
                department.addEmployee(employeeName, position);
                return;
            }
        }
        System.out.println("Department " + departmentName + " not found.");
    }

    // Display company details
    public void displayCompanyDetails() {
        System.out.println("Company: " + name);
        if (departments.isEmpty()) {
            System.out.println(" No departments in this company.");
        } else {
            for (Department department : departments) {
                department.displayDepartmentDetails();
            }
        }
    }

    // Delete the company (clear all departments and employees)
    public void deleteCompany() {
        for (Department department : departments) {
            department.clearEmployees(); // Clear employees in each department
        }
        departments.clear(); // Clear all departments
        System.out.println("Company " + name + " and all associated departments and employees have been deleted.");
    }
}

// Main class to demonstrate the composition relationship
public class company {
    public static void main(String[] args) {
        // Create a company
        Company company = new Company("Tech Innovators");

        // Add departments to the company
        company.addDepartment("Engineering");
        company.addDepartment("Human Resources");
        company.addDepartment("Marketing");

        // Add employees to departments
        company.addEmployeeToDepartment("Engineering", "Alice", "Software Engineer");
        company.addEmployeeToDepartment("Engineering", "Bob", "DevOps Engineer");
        company.addEmployeeToDepartment("Human Resources", "Charlie", "HR Manager");
        company.addEmployeeToDepartment("Marketing", "Diana", "Marketing Specialist");

        // Display company details
        System.out.println("Before Deletion:");
        company.displayCompanyDetails();

        // Delete the company
        System.out.println("\nDeleting company...");
        company.deleteCompany();

        // Attempt to display company details after deletion
        System.out.println("\nAfter Deletion:");
        company.displayCompanyDetails(); // Should show no departments or employees
    }
}
