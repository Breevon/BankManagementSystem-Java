public class Account implements Transactable {
    private int accountNumber;
    private Customer customer;
    private double balance;

    public Account(int accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customer = new Customer(accountNumber, customerName);
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount){
        balance += amount;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error!!! The amount must be positive.");
            return;
        }

        balance += amount;
        System.out.println("Success!!! Deposit Done");
    }

    public void deposit(double amount, String reference) {
        deposit(amount);
        if (amount > 0) {
            System.out.println("Reference Note: " + reference);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error!!! The amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Error!!! You are poor.");
            return;
        }
        balance -= amount;
        System.out.println("Success!!! Withdraw Done");
    }

    @Override
    public boolean transfer(Account targetAccount, double amount) {
        if (amount <= 0) {
            System.out.println("Error!!! The amount must be positive.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Error!!! You are poor again.");
            return false;
        }
        this.balance -= amount;
        targetAccount.depositWithoutInfo(amount);
        System.out.println("Success!!! Transfer Done");
        return true;
    }

    public void depositWithoutInfo(double amount) {
        this.balance += amount;
    }

    public String getAccountType() {
        return "";
    }

    public String accountDetails() {
        return "[" + getAccountType() + "] Account Number: " + accountNumber
                + " | Holder: " + customer.getName()
                + " | Balance: " + balance + " CHF";
    }
}