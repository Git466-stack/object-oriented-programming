package Inheritance;

// Base class Person
class Person {
    protected String name;
    protected int id;

    // Constructor
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Method to display personal details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Interface Worker
interface Worker {
    void performDuties();
}

// Subclass Chef
class Chef extends Person implements Worker {
    private String specialty;

    // Constructor
    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    // Overriding performDuties method
    @Override
    public void performDuties() {
        System.out.println(name + " is cooking " + specialty + " dishes.");
    }

    // Display additional details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Specialty: " + specialty);
    }
}

// Subclass Waiter
class Waiter extends Person implements Worker {
    private int tablesAssigned;

    // Constructor
    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    // Overriding performDuties method
    @Override
    public void performDuties() {
        System.out.println(name + " is serving at " + tablesAssigned + " tables.");
    }

    // Display additional details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Tables Assigned: " + tablesAssigned);
    }
}
public class RestaurantManagementSystem {
    public static void main(String[] args) {
        // Create objects for Chef and Waiter
        Chef chef = new Chef("Gordon", 101, "Italian");
        Waiter waiter = new Waiter("James", 102, 5);

        // Display details and perform duties
        System.out.println("Chef Details:");
        chef.displayDetails();
        chef.performDuties();
        System.out.println();

        System.out.println("Waiter Details:");
        waiter.displayDetails();
        waiter.performDuties();
    }
}
