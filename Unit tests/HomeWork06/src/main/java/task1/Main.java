package task1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(3, 1, 9, 7);
        List<Integer> list2 = Arrays.asList(1, 5, 9);

        ListTools listTools = new ListTools();
        System.out.println(listTools.listCompare(list1, list2));
    }
}
