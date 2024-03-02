package task1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        double average = list.stream()
                .mapToInt(n -> n)
                .filter(n -> n % 2 == 0)
                .average()
                .orElse(0);
        System.out.println(average);
    }
}
