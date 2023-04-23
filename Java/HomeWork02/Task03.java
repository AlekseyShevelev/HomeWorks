/*
 * В файле содержится строка с данными:
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Task03 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("task03.txt", StandardCharsets.UTF_8))) {
            String line = null;

            while ((line = reader.readLine()) != null) {
                String[] result = getInfo(line);
                System.out.println(Arrays.toString(result));
            }
        } catch (IOException ex) {
            System.out.println("Ошибка чтения файла.");
        }
    }

    private static String[] getInfo(String line) {
        StringBuilder sb = new StringBuilder();      

        String[] students = line.replaceAll("^\\[|\\]$", "").split(", ");
        String[] result = new String[students.length];

        for (int i = 0; i < students.length; i++) {
            String[] properties = students[i].replaceAll("^\\{|\\}$", "").split(",");

            sb.setLength(0);

            for (String property : properties) {
                String[] parts = property.split(":");

                switch (parts[0].replaceAll("^\"|\"$", "")) {
                    case  ("фамилия"):
                        sb.append(String.format("Студент %s", parts[1].replaceAll("^\"|\"$", "")));
                        break;
                    case  ("оценка"):
                        sb.append(String.format(" получил %s", parts[1].replaceAll("^\"|\"$", "")));
                        break;
                    case  ("предмет"):
                        sb.append(String.format(" по предмету %s.", parts[1].replaceAll("^\"|\"$", "")));
                        break;
                }        
            }

            result[i] = sb.toString();
        }

        return result;
    }
}
