public class Customer {

    private int customerId;
    private String name;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public int getcustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}
