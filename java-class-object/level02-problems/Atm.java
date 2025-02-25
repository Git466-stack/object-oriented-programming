// BankAccount.java
class BankAccount {
    // Attributes
    private String accountHolder;
    private String accountNumber;
    private double balance;

    // Constructor to initialize the BankAccount object
    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    // Method to display the current balance
    public void displayBalance() {
        System.out.println("Current Balance: $" + balance);
    }
}


public class Atm {
    public static void main(String[] args) {
        // Create a BankAccount object
        BankAccount account = new BankAccount("John Doe", "123456789", 500.0);

        // Display initial balance
        account.displayBalance();

        // Deposit money
        account.deposit(200.0);

        // Withdraw money
        account.withdraw(150.0);

        // Attempt to withdraw more money than available balance
        account.withdraw(600.0);

        // Display final balance
        account.displayBalance();
    }
}
