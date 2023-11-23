package task1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListSort listSort = new ListSort();

        List<Integer> numbers1 = Arrays.asList(3, 1, 5, 9, 7, 8, 2);
        List<Integer> numbers2 = Arrays.asList(3, 1, 5, 9, 7, 8, 2);
        System.out.println("Исходный: " + numbers1);
        System.out.println("Результат: " + listSort.sortListImperative(numbers1));
        System.out.println("Исходный: " + numbers2);
        System.out.println("Результат: " + listSort.sortListDeclarative(numbers2));
    }
}
