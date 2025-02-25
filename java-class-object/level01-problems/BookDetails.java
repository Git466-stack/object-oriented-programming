// Book.java
class Book {
    // Attributes
    private String title;
    private String author;
    private double price;

    // Constructor to initialize the Book object
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display the book details
    public void displayDetails() {
        System.out.println("Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
}

// Main.java
public class BookDetails {
    public static void main(String[] args) {
        // Create a Book object
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", 18.99);

        // Display the details of the book
        book1.displayDetails();
    }
}
