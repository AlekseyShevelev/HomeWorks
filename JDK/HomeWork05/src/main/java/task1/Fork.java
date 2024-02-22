package task1;

public class Fork {
    private final int number;
    private volatile boolean isBusy;

    public Fork(int number) {
        this.number = number;
        this.isBusy = false;
    }

    public int getNumber() {
        return number;
    }

    public synchronized boolean isBusy() {
        return isBusy;
    }

    public synchronized void setBusy(boolean busy) {
        isBusy = busy;
    }
}
