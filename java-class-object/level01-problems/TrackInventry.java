// Item.java
class Item {
    // Attributes
    private int itemCode;
    private String itemName;
    private double price;

    // Constructor to initialize the Item object
    public Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to display item details
    public void displayDetails() {
        System.out.println("Item Details:");
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: $" + price);
    }

    // Method to calculate the total cost for a given quantity
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }
}

// Main.java
public class TrackInventry {
    public static void main(String[] args) {
        // Create an Item object
        Item item1 = new Item(101, "Laptop", 750.00);

        // Display item details
        item1.displayDetails();

        // Calculate and display total cost for a given quantity
        int quantity = 3; // Example quantity
        double totalCost = item1.calculateTotalCost(quantity);
        System.out.println("Total Cost for Quantity " + quantity + ": $" + totalCost);
    }
}
