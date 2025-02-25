// MovieTicket.java
class MovieTicket {
    // Attributes
    private String movieName;
    private int seatNumber;
    private double price;
    private boolean isBooked;

    // Constructor to initialize the MovieTicket object
    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.seatNumber = -1; // Default value indicating no seat assigned yet
        this.price = 0.0;     // Default price
        this.isBooked = false;
    }

    // Method to book a ticket (assign seat and update price)
    public void bookTicket(int seatNumber, double price) {
        if (!isBooked) {
            this.seatNumber = seatNumber;
            this.price = price;
            this.isBooked = true;
            System.out.println("Ticket successfully booked!");
        } else {
            System.out.println("Ticket is already booked!");
        }
    }

    // Method to display ticket details
    public void displayDetails() {
        if (isBooked) {
            System.out.println("Movie Ticket Details:");
            System.out.println("Movie Name: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        } else {
            System.out.println("No ticket booked yet!");
        }
    }
}


public class Movie {
    public static void main(String[] args) {
        // Create a MovieTicket object for a specific movie
        MovieTicket ticket1 = new MovieTicket("Inception");

        // Try to display ticket details before booking
        ticket1.displayDetails();

        // Book the ticket
        ticket1.bookTicket(25, 12.99);

        // Display ticket details after booking
        ticket1.displayDetails();

        // Attempt to book the ticket again
        ticket1.bookTicket(30, 15.00);
    }
}
