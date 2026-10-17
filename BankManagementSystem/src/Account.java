public class Account {

    private int accountNumber;
    private String accountHolder;
    private double balance;

    public Account(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getaccountNumber() {
        return accountNumber;
    }

    public String getaccountHolder() {
        return accountHolder;
    }

    public double getbalance() {
        return balance;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Error!!! \nThe amount must be positive.");
            return;
        }

        balance += amount;
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Error!!! \nThe amount must be positive.");
            return;
        }

        if (amount > balance) {
            System.out.println("Error!!! \nYou are poor.");
            return;
        }

        balance -= amount;
    }

    public String accountDetails() {
        return "Account Number: " + accountNumber
                + " | Account Holder: " + accountHolder
                + " | Balance: " + String.format("%.2f", balance) + " CHF";
    }
}