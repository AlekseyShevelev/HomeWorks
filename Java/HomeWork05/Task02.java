/*
 * Пусть дан список сотрудников:
 * Иван Иванов
 * Светлана Петрова
 * Кристина Белова
 * Анна Мусина
 * Анна Крутова
 * Иван Юрин
 * Петр Лыков
 * Павел Чернов
 * Петр Чернышов
 * Мария Федорова
 * Марина Светлова
 * Мария Савина
 * Мария Рыкова
 * Марина Лугова
 * Анна Владимирова
 * Иван Мечников
 * Петр Петин
 * Иван Ежов
 * 
 * Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
 * Отсортировать по убыванию популярности.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Task02 {
    public static void main(String[] args) {
        String[] employees = new String[] {"Иван Иванов", "Светлана Петрова", "Кристина Белова",
            "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов",
            "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова",
            "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"};

        Map<String, Integer> names = new HashMap<>();
        Map<String, Integer> sortedNames = new LinkedHashMap<>();
        List<Integer> countList = new ArrayList<>();

        for (String name : employees) {
            String[] parts = name.split(" ");

            if (names.containsKey(parts[0])) {
                names.put(parts[0], names.get(parts[0]) + 1);
            } else {
                names.put(parts[0], 1);
            }
        }

        for (Entry<String, Integer> item : names.entrySet()) {
            countList.add(item.getValue());
        }

        countList.sort(Collections.reverseOrder());

        for (Integer count : countList) {
            for (Entry<String, Integer> item : names.entrySet()) {
                if (count == item.getValue()) {
                    sortedNames.put(item.getKey(), count);
                }
            }
        }

        System.out.println(sortedNames);
    }
}
