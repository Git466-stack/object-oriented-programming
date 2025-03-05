class Book {
    // Attributes
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }

    // Method to borrow a book
    public boolean borrowBook() {
        if (isAvailable) {
            isAvailable = false; // Mark the book as borrowed
            System.out.println("You have successfully borrowed \"" + title + "\".");
            return true;
        } else {
            System.out.println("Sorry, \"" + title + "\" is currently not available.");
            return false;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create some book objects
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", 10.99, true);
        Book book2 = new Book("1984", "George Orwell", 15.99, false);

        // Display book details
        System.out.println("Book 1 Details:");
        book1.displayDetails();
        System.out.println();

        System.out.println("Book 2 Details:");
        book2.displayDetails();
        System.out.println();

        // Attempt to borrow books
        System.out.println("Borrowing Book 1:");
        book1.borrowBook();
        System.out.println();

        System.out.println("Borrowing Book 2:");
        book2.borrowBook();
        System.out.println();

        // Display book details after borrowing
        System.out.println("Book 1 Details After Borrowing:");
        book1.displayDetails();
    }
}
