import java.util.LinkedList;
import java.util.Random;

/*
 * Реализуйте очередь с помощью LinkedList со следующими методами:
 * enqueue() - помещает элемент в конец очереди,
 * dequeue() - возвращает первый элемент из очереди и удаляет его,
 * first() - возвращает первый элемент из очереди, не удаляя.
 */

public class Task02 {
    private static LinkedList<Integer> myQueue;

    public static void main(String[] args) {
        myQueue = new LinkedList<>();
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            myQueue.add(rnd.nextInt(100));
        }

        System.out.println(myQueue);
        enqueue(100);
        System.out.println(myQueue);
        System.out.println(dequeue());
        System.out.println(myQueue);
        System.out.println(first());
        System.out.println(myQueue);
    }

    public static void enqueue(int element) {
        myQueue.addLast(element);
    }

    public static int dequeue() {
        return myQueue.remove();
    }

    public static int first() {
        return myQueue.getFirst();
    }
}
