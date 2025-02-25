// CartItem.java
import java.util.ArrayList;

class CartItem {
    // Attributes
    private String itemName;
    private double price;
    private int quantity;

    // Constructor to initialize a CartItem object
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Calculate the total cost for this item
    public double getTotalCost() {
        return price * quantity;
    }
}

// ShoppingCart.java
class ShoppingCart {
    private ArrayList<CartItem> cartItems;

    // Constructor to initialize the shopping cart
    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    // Method to add an item to the cart
    public void addItem(String itemName, double price, int quantity) {
        CartItem newItem = new CartItem(itemName, price, quantity);
        cartItems.add(newItem);
        System.out.println("Added " + quantity + "x " + itemName + " to the cart.");
    }

    // Method to remove an item from the cart
    public void removeItem(String itemName) {
        boolean found = false;
        for (CartItem item : cartItems) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                cartItems.remove(item);
                System.out.println("Removed " + itemName + " from the cart.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(itemName + " not found in the cart!");
        }
    }

    // Method to display the total cost of the cart
    public void displayTotalCost() {
        double totalCost = 0;
        for (CartItem item : cartItems) {
            totalCost += item.getTotalCost();
        }
        System.out.println("Total Cost: $" + totalCost);
    }

    // Method to display all items in the cart
    public void displayCartItems() {
        if (cartItems.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Cart Items:");
            for (CartItem item : cartItems) {
                System.out.println(item.getQuantity() + "x " + item.getItemName() + " @ $" + item.getPrice() + " each");
            }
        }
    }
}


public class Shopping {
    public static void main(String[] args) {
        // Create a ShoppingCart object
        ShoppingCart cart = new ShoppingCart();

        // Add items to the cart
        cart.addItem("Apple", 0.99, 3);
        cart.addItem("Banana", 0.59, 5);

        // Display cart items
        cart.displayCartItems();

        // Display total cost
        cart.displayTotalCost();

        // Remove an item from the cart
        cart.removeItem("Apple");

        // Display cart items after removal
        cart.displayCartItems();

        // Display total cost after removal
        cart.displayTotalCost();
    }
}
