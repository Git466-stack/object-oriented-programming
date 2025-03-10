package Encapsulation;

import java.util.ArrayList;
import java.util.List;

// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters and setters (Encapsulation)
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // Abstract method
    public abstract double calculateInterest();

    // Display account details
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

// Interface Loanable
interface Loanable {
    void applyForLoan(double loanAmount);
    double calculateLoanEligibility();
}

// SavingsAccount class
class SavingsAccount extends BankAccount {
    private double interestRate = 0.04; // 4% annual interest

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit = 5000; // Overdraft limit
    private double loanRate = 0.08; // 8% loan rate

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest for CurrentAccount
    }

    @Override
    public void applyForLoan(double loanAmount) {
        System.out.println("Loan applied for amount: " + loanAmount);
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 3; // Loan eligibility is 3 times the account balance
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}

// Main class
public class BankingSystem {
    public static void main(String[] args) {
        // List to store accounts
        List<BankAccount> accounts = new ArrayList<>();

        // Adding accounts to the list
        accounts.add(new SavingsAccount("SA123", "Alice", 5000));
        accounts.add(new CurrentAccount("CA456", "Bob", 10000));

        // Process accounts
        for (BankAccount account : accounts) {
            System.out.println("=================================");
            account.displayDetails();

            // Calculate and display interest
            double interest = account.calculateInterest();
            System.out.println("Calculated Interest: " + interest);

            // Process loan if applicable
            if (account instanceof Loanable) {
                Loanable loanable = (Loanable) account;
                double eligibility = loanable.calculateLoanEligibility();
                System.out.println("Loan Eligibility: " + eligibility);
                loanable.applyForLoan(5000);
            }
            System.out.println("=================================");
        }

        // Demonstrate deposit and withdrawal
        System.out.println("\n=== Deposit and Withdrawal Example ===");
        BankAccount savingsAccount = accounts.get(0);
        savingsAccount.deposit(2000);
        savingsAccount.withdraw(3000);

        BankAccount currentAccount = accounts.get(1);
        currentAccount.deposit(5000);
        currentAccount.withdraw(15000);
    }
}

