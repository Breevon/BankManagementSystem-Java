public class Bank {
    private Account[] accounts;
    private int accountCount;
    private int nextId;

    public Bank() {
        this.accounts = new Account[100];
        this.accountCount = 0;
        this.nextId = 1;
    }

    public Account createAccount(String type, String holderName, double initialBalance) {
        if (accountCount >= accounts.length) {
            System.out.println("Error: Bank capacity is full!");
            return null;
        }

        Account account;

        switch (type) {
            case "1":
                account = new SavingsAccount(nextId, holderName, initialBalance);
                nextId++;
                break;

            case "2":
                account = new StandardAccount(nextId, holderName, initialBalance);
                nextId++;
                break;

            default:
                System.out.println("Error!!! Invalid input.");
                return null;
        }

        accounts[accountCount] = account;
        accountCount++;

        System.out.println("Success!!! Account Number: " + account.getAccountNumber());
        return account;
    }

    public Account findAccount(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    public void listAllAccounts() {
        if (accountCount == 0) {
            System.out.println("No accounts found.");
            return;
        }

        System.out.println();
        System.out.println("- List of All Accounts -");

        for (int i = 0; i < accountCount; i++) {
            System.out.println(accounts[i].accountDetails());
        }
    }
}