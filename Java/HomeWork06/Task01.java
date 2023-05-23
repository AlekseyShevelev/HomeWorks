import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Task01 {
    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();

        notebooks.add(new Notebook("HP001-8-1024-W-BL", "HP", 8, 1024, "Windows", "black"));
        notebooks.add(new Notebook("HP002-4-512-L-GR", "HP", 4, 512, "Linux", "gray"));
        notebooks.add(new Notebook("DL001-8-512-L-GR", "Dell", 8, 512, "Linux", "gray"));
        notebooks.add(new Notebook("DL002-4-512-D-SL", "Dell", 4, 512, "DOS", "silver"));
        notebooks.add(new Notebook("LN001-4-256-D-WT", "Lenovo", 4, 256, "DOS", "white"));
        notebooks.add(new Notebook("LN002-16-2048-W-BL", "Lenovo", 16, 2048, "Windows", "black"));

        getNotebooks(notebooks);
    }

    private static void getNotebooks(Set<Notebook> notebooks) {
        Map<Integer, String> filters = getFilters();

        for (Notebook notebook : notebooks) {
            boolean isFound = true;

            for (Map.Entry<Integer, String> entry : filters.entrySet()) {
                switch (entry.getKey()) {
                    case 1:
                        isFound = (notebook.getVendor().equals(entry.getValue()));
                        break;

                    case 2:
                        isFound = (notebook.getRam() >= Integer.parseInt(entry.getValue()));
                        break;

                    case 3:
                        isFound = (notebook.getHdd() >= Integer.parseInt(entry.getValue()));
                        break;

                    case 4:
                        isFound = (notebook.getOs().equals(entry.getValue()));
                        break;

                    case 5:
                        isFound = (notebook.getColor().equals(entry.getValue()));
                        break;
                }

                if (!isFound) {
                    break;
                }

            }

            if (isFound) {
                System.out.println(notebook);
            }
        }
    }

    private static Map<Integer, String> getFilters() {
        Map<Integer, String> result = new HashMap<>();

        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("Введите цифру, соответствующую необходимому критерию:\n" +
                    "1-Производитель;\n" +
                    "2-Объем ОЗУ (не менее);\n" +
                    "3-Объем ЖД (не менее);\n" +
                    "4-Операционная система;\n" +
                    "5-Цвет;\n" +
                    "0-Начать поиск");
            int key = Integer.parseInt(scn.nextLine());

            if (key == 0) {
                break;
            }

            System.out.println("Введите значение критерия:");
            String value = scn.nextLine();

            result.put(key, value);
        }

        scn.close();

        return result;
    }
}
