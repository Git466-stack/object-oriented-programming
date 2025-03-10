package Encapsulation;

import java.util.ArrayList;
import java.util.List;

// Abstract class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    // Constructor
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Getters and setters (Encapsulation)
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Concrete method to display item details
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    // Abstract method for loan duration
    public abstract int getLoanDuration();
}

// Interface Reservable
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Book class
class Book extends LibraryItem implements Reservable {
    private boolean isAvailable;

    public Book(String itemId, String title, String author, boolean isAvailable) {
        super(itemId, title, author);
        this.isAvailable = isAvailable;
    }

    @Override
    public int getLoanDuration() {
        return 14; // Books can be borrowed for 14 days
    }

    @Override
    public void reserveItem() {
        if (isAvailable) {
            System.out.println("The book '" + getTitle() + "' has been reserved.");
            isAvailable = false;
        } else {
            System.out.println("The book '" + getTitle() + "' is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

// Magazine class
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // Magazines can be borrowed for 7 days
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable;

    public DVD(String itemId, String title, String author, boolean isAvailable) {
        super(itemId, title, author);
        this.isAvailable = isAvailable;
    }

    @Override
    public int getLoanDuration() {
        return 3; // DVDs can be borrowed for 3 days
    }

    @Override
    public void reserveItem() {
        if (isAvailable) {
            System.out.println("The DVD '" + getTitle() + "' has been reserved.");
            isAvailable = false;
        } else {
            System.out.println("The DVD '" + getTitle() + "' is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create a list to store library items
        List<LibraryItem> libraryItems = new ArrayList<>();

        // Add items to the library
        libraryItems.add(new Book("B101", "The Great Gatsby", "F. Scott Fitzgerald", true));
        libraryItems.add(new Magazine("M202", "National Geographic", "Various"));
        libraryItems.add(new DVD("D303", "Inception", "Christopher Nolan", true));

        // Process items and display details
        for (LibraryItem item : libraryItems) {
            System.out.println("=================================");
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            // If the item is reservable, check availability and reserve it
            if (item instanceof Reservable) {
                Reservable reservable = (Reservable) item;
                System.out.println("Is Available: " + reservable.checkAvailability());
                reservable.reserveItem();
            }
            System.out.println("=================================");
        }
    }
}
