import java.util.ArrayList;

// Account class
class Account {
    private String accountNumber;
    private double balance;

    // Constructor
    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // View balance
    public double getBalance() {
        return balance;
    }

    // Get account number
    public String getAccountNumber() {
        return accountNumber;
    }
}

// Customer class
class Customer {
    private String name;
    private ArrayList<Account> accounts;

    // Constructor
    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    // Add an account
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // View all accounts and balances
    public void viewBalances() {
        System.out.println("Customer: " + name);
        if (accounts.isEmpty()) {
            System.out.println("No accounts for this customer.");
        } else {
            for (Account account : accounts) {
                System.out.println("Account: " + account.getAccountNumber() + ", Balance: " + account.getBalance());
            }
        }
    }
}

// Bank class
class Bank {
    private String name;
    private ArrayList<Customer> customers;

    // Constructor
    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    // Add a new customer
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Open a new account for a customer
    public void openAccount(Customer customer, Account account) {
        customer.addAccount(account);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Account " + account.getAccountNumber() + " opened for " + customer);
    }

    // Display all customers
    public void displayCustomers() {
        System.out.println("Bank: " + name);
        if (customers.isEmpty()) {
            System.out.println("No customers in this bank.");
        } else {
            for (Customer customer : customers) {
                customer.viewBalances();
            }
        }
    }
}

public class bankaccount {
    public static void main(String[] args) {
        // Create a bank
        Bank bank = new Bank("National Bank");

        // Create customers
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        // Create accounts
        Account account1 = new Account("A001", 500.0);
        Account account2 = new Account("A002", 1000.0);
        Account account3 = new Account("A003", 750.0);

        // Open accounts for customers
        bank.openAccount(customer1, account1);
        bank.openAccount(customer1, account2);
        bank.openAccount(customer2, account3);

        // Perform transactions
        account1.deposit(200);
        account2.withdraw(300);
        account3.deposit(500);

        // Display customers and their accounts
        bank.displayCustomers();
    }
}
