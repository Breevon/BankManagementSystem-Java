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
}