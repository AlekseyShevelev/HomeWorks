package task1;

import java.util.Collections;
import java.util.List;

public class ListSort {
    public List<Integer> sortListImperative(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = 0; j < numbers.size() - i - 1; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
        return numbers;
    }

    public List<Integer> sortListDeclarative(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
