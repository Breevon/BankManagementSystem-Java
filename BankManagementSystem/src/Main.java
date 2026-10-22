import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        bank.createAccount("1", "Alice Müller", 1200.50);
        bank.createAccount("2", "Hans Gruber", 5000.00);

        while (running) {
            System.out.println();
            System.out.println("1. Create New Account");
            System.out.println("2. Display All Accounts");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Transfer Between Accounts");
            System.out.println("6. Deposit with Reference");
            System.out.println("7. Apply Interest (Savings Account)");
            System.out.println("8. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println();
                    System.out.println("1. Savings Account");
                    System.out.println("2. Standard Account");
                    String type = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial balance (CHF): ");
                    try {
                        double balance = Double.parseDouble(scanner.nextLine());
                        bank.createAccount(type, name, balance);
                    } catch (Exception e) {
                        System.out.println("Error!!! Invalid input.");
                    }
                    break;
                    
                case "2":
                    bank.listAllAccounts();
                    break;

                case "3":
                    System.out.print("Enter account number: ");
                    try {
                        int accNum = Integer.parseInt(scanner.nextLine());
                        Account acc = bank.findAccount(accNum);
                        if (acc != null) {
                            System.out.print("Enter amount to deposit (CHF): ");
                            double amount = Double.parseDouble(scanner.nextLine());
                            acc.deposit(amount);
                        } else {
                            System.out.println("Error!!! Account number not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error!!! Invalid input.");
                    }
                    break;

                case "4":
                    System.out.print("Enter account number: ");
                    try {
                        int accNum = Integer.parseInt(scanner.nextLine());
                        Account acc = bank.findAccount(accNum);
                        if (acc != null) {
                            System.out.print("Enter amount to withdraw (CHF): ");
                            double amount = Double.parseDouble(scanner.nextLine());
                            acc.withdraw(amount);
                        } else {
                            System.out.println("Error!!! Account number not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error!!! Invalid input.");
                    }
                    break;

                case "5":
                    System.out.print("Enter source account number: ");
                    try {
                        int srcNum = Integer.parseInt(scanner.nextLine());
                        Account srcAcc = bank.findAccount(srcNum);
                        if (srcAcc != null) {
                            System.out.print("Enter target account number: ");
                            int tgtNum = Integer.parseInt(scanner.nextLine());
                            Account tgtAcc = bank.findAccount(tgtNum);
                            if (tgtAcc != null) {
                                System.out.print("Enter transfer amount (CHF): ");
                                double amount = Double.parseDouble(scanner.nextLine());
                                srcAcc.transfer(tgtAcc, amount);
                            } else {
                                System.out.println("Error!!! Target account not found.");
                            }
                        } else {
                            System.out.println("Error!!! Source account not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error!!! Invalid input.");
                    }
                    break;

                case "6":
                    System.out.print("Enter account number: ");
                    try {
                        int accNum = Integer.parseInt(scanner.nextLine());
                        Account acc = bank.findAccount(accNum);
                        if (acc != null) {
                            System.out.print("Enter amount to deposit (CHF): ");
                            double amount = Double.parseDouble(scanner.nextLine());
                            System.out.print("Enter reference note: ");
                            String reference = scanner.nextLine();
                            acc.deposit(amount, reference);
                        } else {
                            System.out.println("Error!!! Account number not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error!!! Invalid input.");
                    }
                    break;

                case "7":
                    System.out.print("Enter savings account number: ");
                    try {
                        int accNum = Integer.parseInt(scanner.nextLine());
                        Account acc = bank.findAccount(accNum);
                        if (acc instanceof SavingsAccount) {
                            ((SavingsAccount) acc).applyInterest();
                        } else if (acc != null) {
                            System.out.println("Error!!! This is not a Savings Account.");
                        } else {
                            System.out.println("Error!!! Account number not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error!!! Invalid input.");
                    }
                    break;

                case "8":
                    running = false;
                    System.out.println("Bye Bye!");
                    break;

                default:
                    System.out.println("Error!!! Invalid option.");
            }
        }
    }
}