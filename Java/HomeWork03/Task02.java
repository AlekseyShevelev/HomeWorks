import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Пусть дан произвольный список целых чисел.
 * Удалить из него чётные числа.
 */

public class Task02 {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            data.add(rnd.nextInt(100));
        }

        System.out.println(data);
        deleteEven(data);
        System.out.println(data);
    }

    private static void deleteEven(List<Integer> data) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) % 2 == 0)
                data.remove(i--);
        }
    }
}
