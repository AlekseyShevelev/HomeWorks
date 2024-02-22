package task1;

public class Main {
    public static void main(String[] args) {
        /*
        1. Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
        2. Вилки лежат на столе между каждой парой ближайших философов.
        3. Каждый философ может либо есть, либо размышлять.
        4. Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
        5. Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
        6. Можно брать только 2 вилки одновременно

        Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза
         */

        Fork fork1 = new Fork(1);
        Fork fork2 = new Fork(2);
        Fork fork3 = new Fork(3);
        Fork fork4 = new Fork(4);
        Fork fork5 = new Fork(5);

        Philosopher philosopher1 = new Philosopher(1, fork1, fork2);
        Philosopher philosopher2 = new Philosopher(2, fork2, fork3);
        Philosopher philosopher3 = new Philosopher(3, fork3, fork4);
        Philosopher philosopher4 = new Philosopher(4, fork4, fork5);
        Philosopher philosopher5 = new Philosopher(5, fork5, fork1);

        TableThread thread1 = new TableThread(philosopher1);
        TableThread thread2 = new TableThread(philosopher2);
        TableThread thread3 = new TableThread(philosopher3);
        TableThread thread4 = new TableThread(philosopher4);
        TableThread thread5 = new TableThread(philosopher5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
