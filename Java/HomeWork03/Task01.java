import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Реализовать алгоритм сортировки слиянием.
 */

public class Task01 {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            data.add(rnd.nextInt(100));
        }

        System.out.println(data);
        sort(data);
        System.out.println(data);
    }

    private static void sort(List<Integer> data) {
        if (data.size() == 1)
            return;

        List<Integer> leftPart = new ArrayList<>(data.subList(0, data.size() / 2));
        List<Integer> rightPart = new ArrayList<>(data.subList(data.size() / 2, data.size()));

        sort(leftPart);
        sort(rightPart);

        int i = 0, j = 0, k = 0;

        while (i < leftPart.size() || j < rightPart.size()) {
            if (j == rightPart.size() || (i < leftPart.size() && leftPart.get(i) < rightPart.get(j)))
                data.set(k++, leftPart.get(i++));
            else
                data.set(k++, rightPart.get(j++));
        }
    }
}
