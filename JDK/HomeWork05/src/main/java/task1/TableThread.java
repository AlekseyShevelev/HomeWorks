package task1;

public class TableThread extends Thread {
    private final Philosopher philosopher;

    public TableThread(Philosopher philosopher) {
        this.philosopher = philosopher;
    }

    @Override
    public void run() {
        System.out.println("Филосов " + philosopher.getNumber() + " сел за стол.");
        while (philosopher.getNumberOfMeals() < Philosopher.DEFAULT_NUMBER_OF_MEALS) {
            try {
                philosopher.doEat();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
