class BankAccount {
    // Attributes
    public String accountNumber;     
    protected String accountHolder;  
    private double balance;          

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to get the balance
    public double getBalance() {
        return balance;
    }

    // Public method to set the balance
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative.");
        }
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

// Subclass to demonstrate access modifiers
class SavingsAccount extends BankAccount {
    private double interestRate; // Additional attribute for savings accounts

    // Constructor
    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Method to display savings account details
    @Override
    public void displayAccountDetails() {
        // Accessing public and protected members
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + accountNumber); // Public
        System.out.println("Account Holder: " + accountHolder); // Protected
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}


public class bankaccountmanagment {
    public static void main(String[] args) {
        // Create a BankAccount object
        BankAccount bankAccount = new BankAccount("123456789", "Alice", 1000.0);
        System.out.println("Bank Account Details:");
        bankAccount.displayAccountDetails();
        System.out.println();

        // Modify and access the balance
        System.out.println("Updating Balance...");
        bankAccount.setBalance(1500.0);
        System.out.println("Updated Balance: $" + bankAccount.getBalance());
        System.out.println();

        // Create a SavingsAccount object
        SavingsAccount savingsAccount = new SavingsAccount("987654321", "Bob", 2000.0, 3.5);
        savingsAccount.displayAccountDetails();
    }
}
