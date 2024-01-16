package task1;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {0, 5, 4, 1, 7, 3, 2};
        System.out.println("Количество чётных элементов массива: " + countEvens(arr1));
        System.out.println("Разница между самым большим и самым маленьким элементами: " + getDiffMinMax(arr1));
        System.out.println("В массиве есть два соседних элемента с нулевым значением: " + checkDoubleZero(arr1));

        int[] arr2 = {1, 7, 4, 0, 0, 3, -2};
        System.out.println("Количество чётных элементов массива: " + countEvens(arr2));
        System.out.println("Разница между самым большим и самым маленьким элементами: " + getDiffMinMax(arr2));
        System.out.println("В массиве есть два соседних элемента с нулевым значением: " + checkDoubleZero(arr2));
    }

    /*
    1. Написать метод, возвращающий количество чётных элементов массива.
    */
    private static int countEvens(int[] arr) {
        int count = 0;

        for (int i : arr) {
            if (i % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    /*
    2. Написать функцию, возвращающую разницу между самым большим и самым маленьким
       элементами переданного не пустого массива.
    */
    private static int getDiffMinMax(int[] arr) {
        int min = arr[0];
        int max = min;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return (max - min);
    }

    /*
    3. Написать функцию, возвращающую истину, если в переданном массиве есть два
       соседних элемента, с нулевым значением.
    */
    private static boolean checkDoubleZero(int[] arr) {
        boolean result = false;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == 0 && arr[i] == 0) {
                result = true;
                break;
            }
        }

        return result;
    }
}