import java.util.ArrayList;
import java.util.List;

// Product class
class Product {
    private String name;
    private double price;

    // Constructor
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter for product name
    public String getName() {
        return name;
    }

    // Getter for product price
    public double getPrice() {
        return price;
    }

    // Display product details
    public void displayProductDetails() {
        System.out.println("  Product: " + name + ", Price: $" + price);
    }
}

// Order class
class Order {
    int orderId;
        private List<Product> products;
        private static int idCounter = 1;
    
        // Constructor
        public Order() {
            this.orderId = idCounter++;
            this.products = new ArrayList<>();
        }
    
        // Add a product to the order
        public void addProduct(Product product) {
            products.add(product);
        }
    
        // Display order details
        public void displayOrderDetails() {
            System.out.println("Order ID: " + orderId);
            if (products.isEmpty()) {
                System.out.println(" No products in this order.");
            } else {
                System.out.println(" Products:");
                for (Product product : products) {
                    product.displayProductDetails();
                }
            }
        }
    
        // Calculate the total price of the order
        public double calculateTotalPrice() {
            double total = 0;
            for (Product product : products) {
                total += product.getPrice();
            }
            return total;
        }
    }
    
    // Customer class
    class Customer {
        private String name;
        private List<Order> orders;
    
        // Constructor
        public Customer(String name) {
            this.name = name;
            this.orders = new ArrayList<>();
        }
    
        // Place an order
        public void placeOrder(Order order) {
            orders.add(order);
            System.out.println("Customer " + name + " placed an order with Order ID: " + order.orderId);
    }

    // Display customer details and their orders
    public void displayCustomerDetails() {
        System.out.println("Customer: " + name);
        if (orders.isEmpty()) {
            System.out.println(" No orders placed yet.");
        } else {
            System.out.println(" Orders:");
            for (Order order : orders) {
                order.displayOrderDetails();
                System.out.println(" Total Price: $" + order.calculateTotalPrice());
                System.out.println();
            }
        }
    }
}

public class ecommerce {
    public static void main(String[] args) {
        // Create products
        Product product1 = new Product("Laptop", 1200.00);
        Product product2 = new Product("Smartphone", 800.00);
        Product product3 = new Product("Headphones", 150.00);

        // Create customers
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        // Create and place orders for customer1
        Order order1 = new Order();
        order1.addProduct(product1);
        order1.addProduct(product2);
        customer1.placeOrder(order1);

        Order order2 = new Order();
        order2.addProduct(product3);
        customer1.placeOrder(order2);

        // Create and place orders for customer2
        Order order3 = new Order();
        order3.addProduct(product2);
        order3.addProduct(product3);
        customer2.placeOrder(order3);

        // Display customer details
        System.out.println("\nCustomer Details:");
        customer1.displayCustomerDetails();
        customer2.displayCustomerDetails();
    }
}
