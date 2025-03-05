class Student {
    // Attributes
    public int rollNumber;  // Public attribute
    protected String name;  // Protected attribute
    private double CGPA;    // Private attribute

    // Constructor
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public method to get CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public method to set CGPA
    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA. It must be between 0.0 and 10.0.");
        }
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// Subclass to demonstrate the use of protected members
class PostgraduateStudent extends Student {
    private String thesisTitle; // Additional attribute for postgraduate students

    // Constructor
    public PostgraduateStudent(int rollNumber, String name, double CGPA, String thesisTitle) {
        super(rollNumber, name, CGPA);
        this.thesisTitle = thesisTitle;
    }

    // Method to display postgraduate student details
    @Override
    public void displayStudentDetails() {
        super.displayStudentDetails();
        System.out.println("Thesis Title: " + thesisTitle);
    }
}

public class universitymanagement {
    public static void main(String[] args) {
        // Create a Student object
        Student student1 = new Student(101, "Alice", 9.2);
        System.out.println("Student Details:");
        student1.displayStudentDetails();
        System.out.println();

        // Modify and access CGPA
        System.out.println("Updating CGPA...");
        student1.setCGPA(9.5);
        System.out.println("Updated CGPA: " + student1.getCGPA());
        System.out.println();

        // Create a PostgraduateStudent object
        PostgraduateStudent pgStudent = new PostgraduateStudent(201, "Bob", 8.8, "Machine Learning in Healthcare");
        System.out.println("Postgraduate Student Details:");
        pgStudent.displayStudentDetails();
    }
}
