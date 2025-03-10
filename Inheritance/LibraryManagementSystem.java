package Inheritance;

// Base class Book
class Book {
    protected String title;
    protected int publicationYear;

    // Constructor
    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Method to display book information
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass Author
class Author extends Book {
    private String name;
    private String bio;

    // Constructor
    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    // Overriding displayInfo method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Bio: " + bio);
    }
}

// Main class to test the Book and Author hierarchy
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create an Author object
        Author author = new Author("The Great Gatsby", 1925, "F. Scott Fitzgerald", "An American novelist and short story writer.");

        // Display book and author details
        System.out.println("Book and Author Details:");
        author.displayInfo();
    }
}
