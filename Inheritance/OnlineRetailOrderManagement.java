package Inheritance;

// Base class Order
class Order {
    protected String orderId;
    protected String orderDate;

    // Constructor
    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // Method to get order status
    public String getOrderStatus() {
        return "Order placed.";
    }

    // Method to display order details
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
    }
}

// Subclass ShippedOrder
class ShippedOrder extends Order {
    protected String trackingNumber;

    // Constructor
    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    // Overriding getOrderStatus method
    @Override
    public String getOrderStatus() {
        return "Order shipped. Tracking Number: " + trackingNumber;
    }

    // Overriding displayOrderDetails method
    @Override
    public void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

// Subclass DeliveredOrder
class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    // Constructor
    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    // Overriding getOrderStatus method
    @Override
    public String getOrderStatus() {
        return "Order delivered on: " + deliveryDate;
    }

    // Overriding displayOrderDetails method
    @Override
    public void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

// Main class to test the Order hierarchy
public class OnlineRetailOrderManagement {
    public static void main(String[] args) {
        // Create objects for each type of order
        Order order = new Order("O1001", "2025-03-10");
        ShippedOrder shippedOrder = new ShippedOrder("O1002", "2025-03-09", "TRK123456");
        DeliveredOrder deliveredOrder = new DeliveredOrder("O1003", "2025-03-08", "TRK789012", "2025-03-10");

        // Display details and status of each order
        System.out.println("Order Details:");
        order.displayOrderDetails();
        System.out.println("Status: " + order.getOrderStatus());
        System.out.println();

        System.out.println("Shipped Order Details:");
        shippedOrder.displayOrderDetails();
        System.out.println("Status: " + shippedOrder.getOrderStatus());
        System.out.println();

        System.out.println("Delivered Order Details:");
        deliveredOrder.displayOrderDetails();
        System.out.println("Status: " + deliveredOrder.getOrderStatus());
    }
}
