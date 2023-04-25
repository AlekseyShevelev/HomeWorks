import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Задан целочисленный список ArrayList.
 * Найти минимальное, максимальное и среднее арифметичское этого списка.
 */

public class Task03 {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            data.add(rnd.nextInt());
        }

        System.out.println(data);

        int min = data.get(0);
        int max = min;
        float sum = 0;

        for (Integer n : data) {
            if (n < min)
                min = n;

            if (n > max)
                max = n;
    
            sum += n;
        }

        System.out.printf("Минимальное = %d, максимальное = %d, среднее арифметическое = %f.\n", min, max, (sum / data.size()));
    }    
}
