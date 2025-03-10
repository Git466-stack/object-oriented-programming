package Encapsulation;

import java.util.ArrayList;
import java.util.List;

// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters (Encapsulation)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Concrete method to display item details
    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per Unit: " + price);
        System.out.println("Quantity: " + quantity);
    }

    // Abstract method for calculating total price
    public abstract double calculateTotalPrice();
}

// Interface Discountable
interface Discountable {
    void applyDiscount(double discountPercentage);
    void getDiscountDetails();
        double calculateTotalPrice();
    }
    
    // VegItem class
    class VegItem extends FoodItem implements Discountable {
        private double discountApplied;
    
        public VegItem(String itemName, double price, int quantity) {
            super(itemName, price, quantity);
            this.discountApplied = 0;
        }
    
        @Override
        public double calculateTotalPrice() {
            return getPrice() * getQuantity();
        }
    
        @Override
        public void applyDiscount(double discountPercentage) {
            double discount = calculateTotalPrice() * (discountPercentage / 100);
            discountApplied = discount;
        }
    
        @Override
        public void getDiscountDetails() {
            System.out.println("Discount Applied: " + discountApplied);
        }
    }
    
    // NonVegItem class
    class NonVegItem extends FoodItem implements Discountable {
        private double additionalCharge;
        private double discountApplied;
    
        public NonVegItem(String itemName, double price, int quantity) {
            super(itemName, price, quantity);
            this.additionalCharge = 10; // Flat additional charge per unit
            this.discountApplied = 0;
        }
    
        @Override
        public double calculateTotalPrice() {
            return (getPrice() + additionalCharge) * getQuantity();
        }
    
        @Override
        public void applyDiscount(double discountPercentage) {
            double discount = calculateTotalPrice() * (discountPercentage / 100);
            discountApplied = discount;
        }
    
        @Override
        public void getDiscountDetails() {
            System.out.println("Discount Applied: " + discountApplied);
        }
    }
    
    // Main class
    public class FoodDeliverySystem {
        public static void main(String[] args) {
            // List to store food items
            List<FoodItem> order = new ArrayList<>();
    
            // Adding items to the order
            order.add(new VegItem("Paneer Butter Masala", 250, 2));
            order.add(new NonVegItem("Chicken Biryani", 350, 1));
            order.add(new NonVegItem("Fish Curry", 400, 2));
    
            // Process the order
            System.out.println("Processing Order...");
            for (FoodItem item : order) {
                System.out.println("=================================");
                item.getItemDetails();
                System.out.println("Total Price Before Discount: " + item.calculateTotalPrice());
    
                // Apply discount if applicable
                if (item instanceof Discountable) {
                    Discountable discountable = (Discountable) item;
                    discountable.applyDiscount(10); // Applying 10% discount
                    discountable.getDiscountDetails();
                    double finalPrice = item.calculateTotalPrice() - ((Discountable) item).calculateTotalPrice() * 0.1;
                System.out.println("Final Price After Discount: " + finalPrice);
            }
            System.out.println("=================================");
        }
    }
}

