class Book {
    // Attributes
    public String ISBN;      
    protected String title;   
    private String author;    

    // Constructor
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public method to get the author name
    public String getAuthor() {
        return author;
    }

    // Public method to set the author name
    public void setAuthor(String author) {
        this.author = author;
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Subclass to demonstrate access modifiers
class EBook extends Book {
    private double fileSize; 

    // Constructor
    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    // Method to display e-book details
    @Override
    public void displayBookDetails() {
        
        System.out.println("EBook Details:");
        System.out.println("ISBN: " + ISBN); 
        System.out.println("Title: " + title);
        System.out.println("File Size: " + fileSize + " MB");
    }
}

public class booklibrarysystem{
    public static void main(String[] args) {
        // Create a Book object
        Book book1 = new Book("123-4567890123", "The Great Gatsby", "F. Scott Fitzgerald");
        System.out.println("Book Details:");
        book1.displayBookDetails();
        System.out.println();

        // Modify and access the author name
        System.out.println("Updating Author Name...");
        book1.setAuthor("Francis Scott Fitzgerald");
        System.out.println("Updated Author Name: " + book1.getAuthor());
        System.out.println();

        // Create an EBook object
        EBook ebook1 = new EBook("987-6543210987", "Digital Fortress", "Dan Brown", 1.5);
        ebook1.displayBookDetails();
    }
}
