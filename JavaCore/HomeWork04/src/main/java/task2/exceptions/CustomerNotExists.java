package task2.exceptions;

public class CustomerNotExists extends Exception {
    public CustomerNotExists() {
    }

    public CustomerNotExists(String message) {
        super(message);
    }
}
