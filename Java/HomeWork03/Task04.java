import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Даны два ArrayList из целых чисел. Написать функции, которые вычисляют разницу коллекций:
 * Разность:
 * A - B = все числа из первой коллекции, которые не содержатся во второй коллекции
 * B - A = все числа из второй коллекции, которые не содержатся в первой
 * Симметрическая разность:
 * A ^ B = числа из первой коллекции, которых нет во второй, А ТАКЖЕ числа из второй, которых нет в первой
 */

public class Task04 {
    public static void main(String[] args) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            listA.add(rnd.nextInt(10));
            listB.add(rnd.nextInt(10));
        }

        System.out.println(listA);
        System.out.println(listB);
        System.out.println();

        System.out.println(getAMinusB(listA, listB));
        System.out.println(getBMinusA(listA, listB));
        System.out.println(getSymmetricDiff(listA, listB));
    }

    private static List<Integer> getAMinusB(List<Integer> listA, List<Integer> listB) {
        List<Integer> result = new ArrayList<>();

        for (Integer n : listA) {
            if (!listB.contains(n))
                result.add(n);
        }

        return result;
    }

    private static List<Integer> getBMinusA(List<Integer> listA, List<Integer> listB) {
        List<Integer> result = new ArrayList<>();

        for (Integer n : listB) {
            if (!listA.contains(n))
                result.add(n);
        }

        return result;
    }

    private static List<Integer> getSymmetricDiff(List<Integer> listA, List<Integer> listB) {
        List<Integer> result = new ArrayList<>();

        result.addAll(getAMinusB(listA, listB));
        result.addAll(getBMinusA(listA, listB));

        return result;
    }
}
