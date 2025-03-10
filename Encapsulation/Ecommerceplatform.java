package Encapsulation;

import java.util.ArrayList;
import java.util.List;

// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters and setters (Encapsulation)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method
    public abstract double calculateDiscount();

    // Method to display product details
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

// Interface Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics class
class Electronics extends Product implements Taxable {
    private double taxRate = 0.18; // 18% tax
    private double discountRate = 0.10; // 10% discount

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: " + (taxRate * 100) + "%";
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    private double taxRate = 0.05; // 5% tax
    private double discountRate = 0.15; // 15% discount

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: " + (taxRate * 100) + "%";
    }
}

// Groceries class
class Groceries extends Product {
    private double discountRate = 0.05; // 5% discount

    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }

    // No tax for groceries, so no need to implement Taxable
}

// Main class
public class Ecommerceplatform {
    public static void main(String[] args) {
        // Create a list of products
        List<Product> products = new ArrayList<>();

        // Adding different products
        products.add(new Electronics(101, "Smartphone", 50000));
        products.add(new Clothing(102, "Jeans", 2000));
        products.add(new Groceries(103, "Rice", 500));

        // Calculate and display final price for each product
        for (Product product : products) {
            System.out.println("=================================");
            product.displayDetails();

            // Calculate discount and tax
            double discount = product.calculateDiscount();
            double tax = 0;

            if (product instanceof Taxable) {
                tax = ((Taxable) product).calculateTax();
                System.out.println(((Taxable) product).getTaxDetails());
            }

            // Calculate final price
            double finalPrice = product.getPrice() + tax - discount;
            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("=================================");
        }
    }
}

