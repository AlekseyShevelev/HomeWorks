package task2.exceptions;

public class ProductNotExists extends Exception {
    public ProductNotExists() {
    }

    public ProductNotExists(String message) {
        super(message);
    }
}
