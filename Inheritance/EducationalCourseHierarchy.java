package Inheritance;

// Base class Course
class Course {
    protected String courseName;
    protected int duration; // in weeks

    // Constructor
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Method to display course details
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

// Subclass OnlineCourse
class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    // Constructor
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    // Overriding displayCourseDetails method
    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass PaidOnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount; // as a percentage

    // Constructor
    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    // Method to calculate the final fee after discount
    public double calculateFinalFee() {
        return fee - (fee * discount / 100);
    }

    // Overriding displayCourseDetails method
    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Fee: $" + calculateFinalFee());
    }
}

// Main class to test the Course hierarchy
public class EducationalCourseHierarchy {
    public static void main(String[] args) {
        // Create objects for each type of course
        Course course = new Course("Introduction to Programming", 8);
        OnlineCourse onlineCourse = new OnlineCourse("Advanced Java", 10, "Coursera", true);
        PaidOnlineCourse paidOnlineCourse = new PaidOnlineCourse("Data Science Bootcamp", 12, "Udemy", true, 500.0, 20.0);

        // Display details of each course
        System.out.println("Course Details:");
        course.displayCourseDetails();
        System.out.println();

        System.out.println("Online Course Details:");
        onlineCourse.displayCourseDetails();
        System.out.println();

        System.out.println("Paid Online Course Details:");
        paidOnlineCourse.displayCourseDetails();
    }
}

