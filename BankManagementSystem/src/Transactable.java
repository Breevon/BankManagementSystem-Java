interface Transactable {
    void deposit(double amount);
    void withdraw(double amount);
    boolean transfer(Account targetAccount, double amount);
}