class Product {
    // Instance variables
    private String productName;
    private double price;

    // Class variable
    private static int totalProducts = 0;

    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // Increment total products count when a new product is created
    }

    // Instance method to display product details
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
    }

    // Class method to display the total number of products created
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating product objects
        Product product1 = new Product("Laptop", 1200.50);
        Product product2 = new Product("Smartphone", 799.99);
        Product product3 = new Product("Headphones", 199.99);

        // Display details of each product
        System.out.println("Product 1 Details:");
        product1.displayProductDetails();
        System.out.println();

        System.out.println("Product 2 Details:");
        product2.displayProductDetails();
        System.out.println();

        System.out.println("Product 3 Details:");
        product3.displayProductDetails();
        System.out.println();

        // Display total number of products
        Product.displayTotalProducts();
    }
}
