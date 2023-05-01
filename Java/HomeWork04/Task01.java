import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
 * Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
 */

public class Task01 {
    public static void main(String[] args) {
        List<Integer> data = new LinkedList<>();
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            data.add(rnd.nextInt(100));
        }

        System.out.println(data);
        System.out.println(reverse(data));
    }

    private static List<Integer> reverse(List<Integer> data) {
        LinkedList<Integer> result = new LinkedList<>();

        for (Integer n : data) {
            result.addFirst(n);
        }

        return result;
    }
}