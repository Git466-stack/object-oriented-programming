import java.util.ArrayList;
import java.util.List;

// Course class
class Course {
    private String courseName;
    private Professor professor;
    private List<Student> enrolledStudents;

    // Constructor
    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    // Getter for course name
    public String getCourseName() {
        return courseName;
    }

    // Assign a professor to this course
    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println("Professor " + professor.getName() + " has been assigned to course: " + courseName);
    }

    // Enroll a student in this course
    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            System.out.println("Student " + student.getName() + " has enrolled in course: " + courseName);
        }
    }

    // Display course details
    public void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        if (professor != null) {
            System.out.println(" Taught by: Professor " + professor.getName());
        } else {
            System.out.println(" No professor assigned yet.");
        }

        if (enrolledStudents.isEmpty()) {
            System.out.println(" No students enrolled yet.");
        } else {
            System.out.println(" Enrolled Students:");
            for (Student student : enrolledStudents) {
                System.out.println("  " + student.getName());
            }
        }
    }
}

// Student class
class Student {
    private String name;
    private List<Course> enrolledCourses;

    // Constructor
    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    // Getter for student name
    public String getName() {
        return name;
    }

    // Enroll in a course
    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.enrollStudent(this); // Establish bi-directional association
        }
    }

    // Display student's enrolled courses
    public void displayEnrolledCourses() {
        System.out.println("Student: " + name);
        if (enrolledCourses.isEmpty()) {
            System.out.println(" No courses enrolled.");
        } else {
            System.out.println(" Enrolled Courses:");
            for (Course course : enrolledCourses) {
                System.out.println("  " + course.getCourseName());
            }
        }
    }
}

// Professor class
class Professor {
    private String name;
    private List<Course> assignedCourses;

    // Constructor
    public Professor(String name) {
        this.name = name;
        this.assignedCourses = new ArrayList<>();
    }

    // Getter for professor name
    public String getName() {
        return name;
    }

    // Assign a course to the professor
    public void assignCourse(Course course) {
        if (!assignedCourses.contains(course)) {
            assignedCourses.add(course);
            course.assignProfessor(this); // Establish bi-directional association
        }
    }

    // Display professor's assigned courses
    public void displayAssignedCourses() {
        System.out.println("Professor: " + name);
        if (assignedCourses.isEmpty()) {
            System.out.println(" No courses assigned.");
        } else {
            System.out.println(" Assigned Courses:");
            for (Course course : assignedCourses) {
                System.out.println("  " + course.getCourseName());
            }
        }
    }
}

public class Universitymanagment {
    public static void main(String[] args) {
        // Create courses
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Physics");
        Course course3 = new Course("Computer Science");

        // Create professors
        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");

        // Create students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        Student student3 = new Student("Charlie");

        // Assign professors to courses
        professor1.assignCourse(course1);
        professor2.assignCourse(course2);

        // Enroll students in courses
        student1.enrollCourse(course1);
        student1.enrollCourse(course2);
        student2.enrollCourse(course1);
        student3.enrollCourse(course3);

        // Display course details
        System.out.println("\nCourse Details:");
        course1.displayCourseDetails();
        course2.displayCourseDetails();
        course3.displayCourseDetails();

        // Display professor details
        System.out.println("\nProfessor Details:");
        professor1.displayAssignedCourses();
        professor2.displayAssignedCourses();

        // Display student details
        System.out.println("\nStudent Details:");
        student1.displayEnrolledCourses();
        student2.displayEnrolledCourses();
        student3.displayEnrolledCourses();
    }
}
