package task1;

public class Philosopher {
    public static final int DEFAULT_NUMBER_OF_MEALS = 3;

    private final int number;
    private final Fork leftFork, rightFork;
    private int numberOfMeals;
    private boolean isWantToEat;

    public Philosopher(int number, Fork leftFork, Fork rightFork) {
        this.number = number;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.numberOfMeals = 0;
        this.isWantToEat = true;
    }

    public int getNumber() {
        return number;
    }

    public int getNumberOfMeals() {
        return numberOfMeals;
    }

    public void doEat() throws InterruptedException {
        if (isWantToEat && !leftFork.isBusy() && !rightFork.isBusy()) {
            leftFork.setBusy(true);
            rightFork.setBusy(true);
            numberOfMeals++;
            System.out.println("Филосов " + number +
                    " кушает " + numberOfMeals +
                    "-й раз вилками " + leftFork.getNumber() +
                    " и " + rightFork.getNumber() + "...");
            Thread.sleep(5000);
            System.out.println("Филосов " + number + " поел " + numberOfMeals + "-й раз!");
            leftFork.setBusy(false);
            rightFork.setBusy(false);
            isWantToEat = false;
        } else {
            System.out.println("Филосов " + number + " отдыхает...");
            Thread.sleep(10000);
            System.out.println("Филосов " + number + " отдохнул!");
            isWantToEat = true;
        }
    }
}
