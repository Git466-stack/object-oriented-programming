import java.util.ArrayList;
import java.util.List;

// Faculty class
class Faculty {
    private String name;
    private String specialization;

    // Constructor
    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    // Display faculty details
    public void displayFacultyDetails() {
        System.out.println("  Faculty: " + name + ", Specialization: " + specialization);
    }
}

// Department class
class Department {
    private String departmentName;

    // Constructor
    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    // Getter for department name
    public String getDepartmentName() {
        return departmentName;
    }

    // Display department details
    public void displayDepartmentDetails() {
        System.out.println("  Department: " + departmentName);
    }
}

// University class
class University {
    private String universityName;
    private List<Department> departments; // Composition
    private List<Faculty> faculties; // Aggregation

    // Constructor
    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    // Add a department to the university
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    // Add a faculty member to the university
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    // Display university details
    public void displayUniversityDetails() {
        System.out.println("University: " + universityName);

        // Display departments
        if (departments.isEmpty()) {
            System.out.println(" No departments in this university.");
        } else {
            System.out.println(" Departments:");
            for (Department department : departments) {
                department.displayDepartmentDetails();
            }
        }

        // Display faculties
        if (faculties.isEmpty()) {
            System.out.println(" No faculty members in this university.");
        } else {
            System.out.println(" Faculty Members:");
            for (Faculty faculty : faculties) {
                faculty.displayFacultyDetails();
            }
        }
    }

    // Delete the university (deletes all departments)
    public void deleteUniversity() {
        departments.clear(); // Delete all departments
        System.out.println("University " + universityName + " and all its departments have been deleted.");
    }
}

// Main class to demonstrate composition and aggregation
public class universityfaculty {
    public static void main(String[] args) {
        // Create a university
        University university = new University("Global Tech University");

        // Add departments to the university
        university.addDepartment("Computer Science");
        university.addDepartment("Mechanical Engineering");
        university.addDepartment("Business Administration");

        // Create faculty members
        Faculty faculty1 = new Faculty("Alice", "Artificial Intelligence");
        Faculty faculty2 = new Faculty("Bob", "Thermodynamics");
        Faculty faculty3 = new Faculty("Charlie", "Finance");

        // Add faculty members to the university
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);
        university.addFaculty(faculty3);

        // Display university details
        System.out.println("Before Deletion:");
        university.displayUniversityDetails();

        // Delete the university
        System.out.println("\nDeleting university...");
        university.deleteUniversity();

        // Display university details after deletion
        System.out.println("\nAfter Deletion:");
        university.displayUniversityDetails(); // Should show no departments
    }
}
