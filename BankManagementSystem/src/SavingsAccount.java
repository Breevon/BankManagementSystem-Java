public class SavingsAccount extends Account {
    private double interestRate = 0.015;

    public SavingsAccount(int accountNumber, String customerName, double balance) {
        super(accountNumber, customerName, balance);
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        setBalance(interest);
        System.out.println("Success!!! Applied interest of " + interest + " CHF.");
    }

    @Override
    public String getAccountType() {
        return "Savings Account";
    }
}