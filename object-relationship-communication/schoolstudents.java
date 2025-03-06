import java.util.ArrayList;
import java.util.List;

// Course class
class Course {
    private String courseName;
    private List<Student> enrolledStudents;

    // Constructor
    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    // Getter for the course name
    public String getCourseName() {
        return courseName;
    }

    // Add a student to this course
    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.addCourse(this); // Ensure the relationship is bi-directional
        }
    }

    // Display all students enrolled in this course
    public void displayEnrolledStudents() {
        System.out.println("Course: " + courseName);
        if (enrolledStudents.isEmpty()) {
            System.out.println(" No students are enrolled in this course.");
        } else {
            for (Student student : enrolledStudents) {
                System.out.println("  Student: " + student.getName());
            }
        }
    }
}

// Student class
class Student {
    private String name;
    private List<Course> courses;

    // Constructor
    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Getter for student name
    public String getName() {
        return name;
    }

    // Add a course to this student
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    // Display the courses this student is enrolled in
    public void displayEnrolledCourses() {
        System.out.println("Student: " + name);
        if (courses.isEmpty()) {
            System.out.println(" No courses enrolled.");
        } else {
            for (Course course : courses) {
                System.out.println("  Course: " + course.getCourseName());
            }
        }
    }
}

// School class
class School {
    private String schoolName;
    private List<Student> students;

    // Constructor
    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    // Add a student to the school
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    // Display all students in the school
    public void displayStudents() {
        System.out.println("School: " + schoolName);
        if (students.isEmpty()) {
            System.out.println(" No students in this school.");
        } else {
            for (Student student : students) {
                System.out.println("  Student: " + student.getName());
            }
        }
    }
}

// Main class to demonstrate the relationships
public class schoolstudents {
    public static void main(String[] args) {
        // Create a school
        School school = new School("Greenfield High");

        // Create students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        Student student3 = new Student("Charlie");

        // Add students to the school
        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);

        // Create courses
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Science");
        Course course3 = new Course("History");

        // Enroll students in courses
        course1.enrollStudent(student1);
        course1.enrollStudent(student2);
        course2.enrollStudent(student1);
        course2.enrollStudent(student3);
        course3.enrollStudent(student2);

        // Display school details
        System.out.println("School Details:");
        school.displayStudents();

        // Display courses for each student
        System.out.println("\nStudent Course Details:");
        student1.displayEnrolledCourses();
        student2.displayEnrolledCourses();
        student3.displayEnrolledCourses();

        // Display enrolled students for each course
        System.out.println("\nCourse Enrollment Details:");
        course1.displayEnrolledStudents();
        course2.displayEnrolledStudents();
        course3.displayEnrolledStudents();
    }
}
