package task1;

import java.util.Scanner;
import java.util.Arrays;

import static java.util.Arrays.sort;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 7, 8, 10, 13, 14};
        System.out.println("Введите число для поиска в массиве:");
        Scanner scn = new Scanner(System.in);
        int value = scn.nextInt();
        scn.close();

        System.out.printf("Число %d имеет индекс %d.\n", value, search(arr, value));
    }

    private static int search(int[] arr, int value) {
        sort(arr);
        int index = Arrays.binarySearch(arr, value);
        return (index < 0) ? -1 : index;
    }
}
