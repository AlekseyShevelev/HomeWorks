import java.util.Arrays;
import java.util.Random;

/*
 * Реализовать алгоритм пирамидальной сортировки (HeapSort)
 */

public class Task03 {
    public static void main(String[] args) {
        int[] data = new int[7];

        Random rnd = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = rnd.nextInt(100);
        }

        System.out.println(Arrays.toString(data));
        heapSort(data);
        System.out.println(Arrays.toString(data));
    }

    private static void heapSort(int[] data) {
        int size = data.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(data, size, i);
        }

        while (size > 1) {
            swap(data, 0, size - 1);
            size--;
            heapify(data, size, 0);
        }
    }

    private static void heapify(int[] data, int size, int index) {
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        int largest = index;

        if (leftIndex < size && data[leftIndex] > data[largest]) {
            largest = leftIndex;
        }

        if (rightIndex < size && data[rightIndex] > data[largest]) {
            largest = rightIndex;
        }

        if (largest != index) {
            swap(data, index, largest);
            heapify(data, size, largest);
        }
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}