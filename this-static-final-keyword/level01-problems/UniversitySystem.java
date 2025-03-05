class Student{
    private static String universityName = "Chitkara University";
    private final int rollNumber;// Final variable
    private String name;
    private String grade;

    public Student(int rollNumber , String name, String grade){
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
    }

    public void displayStudentDetails(){
        if(this instanceof Student){
            System.out.println("University: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }
}

public class UniversitySystem{
    public static void main(String[] args) {
        Student stu1 = new Student(101, "Subham", "A");
        Student stu2 = new Student(102, "Shivam", "A");

        stu1.displayStudentDetails();
        stu2.displayStudentDetails();
    }
}