package Inheritance;

// Base class Person
class Person {
    protected String name;
    protected int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display personal details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Method to display role (to be overridden by subclasses)
    public void displayRole() {
        System.out.println("General Person");
    }
}

// Subclass Teacher
class Teacher extends Person {
    private String subject;

    // Constructor
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    // Overriding displayRole method
    @Override
    public void displayRole() {
        System.out.println("Role: Teacher");
    }

    // Display additional details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Subject: " + subject);
    }
}

// Subclass Student
class Student extends Person {
    private String grade;

    // Constructor
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    // Overriding displayRole method
    @Override
    public void displayRole() {
        System.out.println("Role: Student");
    }

    // Display additional details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Grade: " + grade);
    }
}

// Subclass Staff
class Staff extends Person {
    private String department;

    // Constructor
    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    // Overriding displayRole method
    @Override
    public void displayRole() {
        System.out.println("Role: Staff");
    }

    // Display additional details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Department: " + department);
    }
}

// Main class to test the Person hierarchy
public class SchoolSystemRoles {
    public static void main(String[] args) {
        // Create objects for each role
        Teacher teacher = new Teacher("Alice", 35, "Mathematics");
        Student student = new Student("Bob", 16, "10th Grade");
        Staff staff = new Staff("Charlie", 40, "Administration");

        // Display details and roles of each person
        System.out.println("Teacher Details:");
        teacher.displayRole();
        teacher.displayDetails();
        System.out.println();

        System.out.println("Student Details:");
        student.displayRole();
        student.displayDetails();
        System.out.println();

        System.out.println("Staff Details:");
        staff.displayRole();
        staff.displayDetails();
    }
}

