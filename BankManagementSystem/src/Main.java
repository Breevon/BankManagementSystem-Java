public class Main {
    public static void main(String[] args){
        System.out.println("Hello World");

        Account test = new Account(1, "Test", 100);
        test.deposit(3);
        System.out.println("Your balance: " + test.getbalance());
        System.out.println();

        System.out.println(test.accountDetails());
    }
}