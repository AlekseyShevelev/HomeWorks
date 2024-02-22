package task1;

import java.util.Random;

public class Philosopher extends Thread {
    private final Table table;
    private final String name;
    private final Fork leftFork, rightFork;
    private int numberOfMeals;
    private final Random rnd;

    public Philosopher(Table table, String name, Fork leftFork, Fork rightFork) {
        this.table = table;
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.numberOfMeals = 0;
        this.rnd = new Random();
    }

    private void doEat() throws InterruptedException {
        if (table.tryGetForks(leftFork, rightFork)) {
            numberOfMeals++;
            System.out.println(name +
                    " кушает " + numberOfMeals +
                    "-й раз вилками " + leftFork.getNumber() +
                    " и " + rightFork.getNumber() + "...");
            Thread.sleep(rnd.nextInt(1000, 5000));
            System.out.println(name + " поел " + numberOfMeals + "-й раз!");
            table.releaseForks(leftFork, rightFork);
        }
    }

    private void doRest() throws InterruptedException {
        System.out.println(name + " отдыхает...");
        Thread.sleep(rnd.nextInt(100, 3000));
        System.out.println(name + " отдохнул!");
    }

    @Override
    public void run() {
        System.out.println(name + " сел за стол.");
        while (numberOfMeals < table.getNumberOfMeals()) {
            try {
                doEat();
                doRest();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " наелся.");
        table.getCdl().countDown();
    }
}
