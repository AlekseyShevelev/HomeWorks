package task1;

import java.util.List;

public class ListTools {
    public String listCompare(List<Integer> list1, List<Integer> list2) {
        double avgList1 = getAverage(list1);
        double avgList2 = getAverage(list2);

        if (avgList1 > avgList2) {
            return "Первый список имеет большее среднее значение";
        } else if (avgList1 < avgList2) {
            return "Второй список имеет большее среднее значение";
        }

         return "Средние значения равны";
    }

    private double getAverage(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Список чисел пуст или равен null.");
        }

        int sumList = 0;

        for (int n: list) {
            sumList += n;
        }

        return (double) sumList / list.size();
    }
}
