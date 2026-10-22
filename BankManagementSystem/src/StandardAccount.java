public class StandardAccount extends Account {
    private double limit;

    public StandardAccount(int accountNumber, String customerName, double balance) {
        super(accountNumber, customerName, balance);
        this.limit = 500.0;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error!!! The amount must be positive.");
            return;
        }
        if (amount > (getBalance() + limit)) {
            System.out.println("Error!!! Exceeds limit (" + limit + " CHF).");
            return;
        }
        setBalance(-amount);
        System.out.println("Success!!! Withdraw Done");
    }

    @Override
    public String getAccountType() {
        return "Standard Account";
    }
}