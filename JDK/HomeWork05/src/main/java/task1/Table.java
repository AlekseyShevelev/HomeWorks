package task1;

import java.util.concurrent.CountDownLatch;

public class Table extends Thread {
    private final Philosopher[] philosophers;
    private final Fork[] forks;

    private final int numberOfMeals;
    private final CountDownLatch cdl;

    public Table(int numberOfPhilosophers, int numberOfMeals) {
        this.philosophers = new Philosopher[numberOfPhilosophers];
        this.forks = new Fork[numberOfPhilosophers];
        this.numberOfMeals = numberOfMeals;
        this.cdl = new CountDownLatch(numberOfPhilosophers);
        init();
    }

    private void init() {
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork(i + 1);
        }

        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new Philosopher(
                    this,
                    "Философ №" + (i + 1),
                    forks[i],
                    forks[(i + 1) % forks.length]);
        }
    }

    public int getNumberOfMeals() {
        return numberOfMeals;
    }

    public CountDownLatch getCdl() {
        return cdl;
    }

    public synchronized boolean tryGetForks(Fork leftFork, Fork rightFork) {
        if (!leftFork.isBusy() && !rightFork.isBusy()) {
            leftFork.setBusy(true);
            rightFork.setBusy(true);
            return true;
        }
        return false;
    }

    public void releaseForks(Fork leftFork, Fork rightFork) {
        leftFork.setBusy(false);
        rightFork.setBusy(false);
    }

    @Override
    public void run() {
        System.out.println("* Начинаем философский ужин!");
        try {
            for (Philosopher philosopher : philosophers) {
                philosopher.start();
            }
            cdl.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("* Философский ужин закончен!");
    }
}
