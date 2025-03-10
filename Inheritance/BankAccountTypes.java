package Inheritance;

// Base class BankAccount
class BankAccount {
    protected String accountNumber;
    protected double balance;

    // Constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }

    // Method to display account type (to be overridden by subclasses)
    public void displayAccountType() {
        System.out.println("Generic Bank Account");
    }
}

// Subclass SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate; // in percentage

    // Constructor
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    // Overriding displayAccountType method
    @Override
    public void displayAccountType() {
        System.out.println("Savings Account");
    }

    // Display additional details
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Subclass CheckingAccount
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    // Constructor
    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    // Overriding displayAccountType method
    @Override
    public void displayAccountType() {
        System.out.println("Checking Account");
    }

    // Display additional details
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}

// Subclass FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    private int depositTerm; // in months

    // Constructor
    public FixedDepositAccount(String accountNumber, double balance, int depositTerm) {
        super(accountNumber, balance);
        this.depositTerm = depositTerm;
    }

    // Overriding displayAccountType method
    @Override
    public void displayAccountType() {
        System.out.println("Fixed Deposit Account");
    }

    // Display additional details
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Deposit Term: " + depositTerm + " months");
    }
}

// Main class to test the BankAccount hierarchy
public class BankAccountTypes {
    public static void main(String[] args) {
        // Create objects for each type of account
        SavingsAccount savingsAccount = new SavingsAccount("SA12345", 1000.0, 2.5);
        CheckingAccount checkingAccount = new CheckingAccount("CA12345", 500.0, 300.0);
        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount("FD12345", 2000.0, 12);

        // Display details and type of each account
        System.out.println("Savings Account Details:");
        savingsAccount.displayAccountType();
        savingsAccount.displayAccountDetails();
        System.out.println();

        System.out.println("Checking Account Details:");
        checkingAccount.displayAccountType();
        checkingAccount.displayAccountDetails();
        System.out.println();

        System.out.println("Fixed Deposit Account Details:");
        fixedDepositAccount.displayAccountType();
        fixedDepositAccount.displayAccountDetails();
    }
}

