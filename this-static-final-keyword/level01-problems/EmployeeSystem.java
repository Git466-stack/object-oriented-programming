class Employee{
    private static String companyName = "Bridge Lab";
    private static int totalEmployees = 0; // Static Counter 
    private final int id ;// Final variable
    private String name;
    private String designation;

    public Employee(int id, String name, String designation){
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }
    public void displayEmployeeDetails(){
        if(this instanceof Employee){
            System.out.println("Company: " + companyName);
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
    }
    public static void displayTotalEmployees(){
        System.out.println("Total Employees: " + totalEmployees);
    }
}

public class EmployeeSystem{
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Subham", "Software Engineer");
        Employee emp2 = new Employee(2, "Shivam", "Manager");

        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();
        Employee.displayTotalEmployees();
        
    }
}