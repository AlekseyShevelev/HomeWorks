package task2.exceptions;

public class WrongQuantity extends Exception {
    private String customer;
    private String product;

    public WrongQuantity(String message) {
        super(message);
    }

    public WrongQuantity(String message, String customer, String product) {
        super(message);
        this.customer = customer;
        this.product = product;
    }

    public String getCustomer() {
        return customer;
    }

    public String getProduct() {
        return product;
    }
}
