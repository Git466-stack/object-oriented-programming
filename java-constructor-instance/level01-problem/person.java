class Person {
    // Instance variables
    private String name;
    private int age;

    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Method to display person details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating a person using the parameterized constructor
        Person originalPerson = new Person("Alice", 25);
        System.out.println("Original Person Details:");
        originalPerson.displayDetails();

        System.out.println();

        // Creating a copy of the original person using the copy constructor
        Person clonedPerson = new Person(originalPerson);
        System.out.println("Cloned Person Details:");
        clonedPerson.displayDetails();
    }
}
