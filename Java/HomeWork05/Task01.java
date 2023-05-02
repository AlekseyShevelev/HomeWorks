import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

/*
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 */

public class Task01 {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        Scanner scn = new Scanner(System.in, "cp866");

        boolean isContinue = true;

        while (isContinue) {
            System.out.println("""
                    Введите операцию:
                    1 - Добавление телефона
                    2 - Удаление по имени
                    3 - Поиск по имени
                    4 - Показать всю книгу
                    0 - Выход:""");

            int operation = Integer.parseInt(scn.nextLine());

            switch (operation) {
                case 1:
                    addPhone(phoneBook, scn);
                    break;

                case 2:
                    delName(phoneBook, scn);
                    break;

                case 3:
                    findName(phoneBook, scn);
                    break;

                case 4:
                    printBook(phoneBook);
                    break;

                case 0:
                    isContinue = false;
                    break;

                default:
                    System.out.println("Неверная операция.");
                    break;
            }

        }

        scn.close();
    }

    public static void addPhone(Map<String, List<String>> phoneBook, Scanner scn) {
        System.out.println("Введите имя: ");
        String name = scn.nextLine();
        System.out.println("Введите телефон: ");
        String phone = scn.nextLine();

        List<String> phones;

        if (phoneBook.containsKey(name)) {
            phones = phoneBook.get(name);
        } else {
            phones = new LinkedList<>();
        }

        phones.add(phone);
        phoneBook.put(name, phones);
    }

    public static void delName(Map<String, List<String>> phoneBook, Scanner scn) {
        System.out.println("Введите имя, которое надо удалить: ");
        String name = scn.nextLine();

        phoneBook.remove(name);
    }

    public static void findName(Map<String, List<String>> phoneBook, Scanner scn) {
        System.out.println("Введите имя для поиска: ");
        String name = scn.nextLine();

        if (phoneBook.containsKey(name)) {
            System.out.printf("%s: %s\n", name, phoneBook.get(name));
        } else {
            System.out.println("Такого имени в книге нет.");
        }
    }

    public static void printBook(Map<String, List<String>> phoneBook) {
        for (Entry<String, List<String>> item : phoneBook.entrySet()) {
            System.out.printf("%s: %s\n", item.getKey(), item.getValue());
        }

        System.out.println();
    }
}
