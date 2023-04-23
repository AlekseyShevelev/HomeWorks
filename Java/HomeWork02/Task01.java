
/*
* В файле содержится строка с исходными данными в такой форме:
* {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
* Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
* SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
* Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task01 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("task01.txt"))) {
            String line = null;
            StringBuilder sb = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                String[] columns = line.replaceAll("^\\{|\\}$", "").split(", ");

                sb.append("SELECT * FROM students WHERE");

                boolean firstCol = true;

                for (String column : columns) {
                    String[] parts = column.split(":");

                    if (!parts[1].equals("\"null\"")) {
                        if (firstCol)
                            firstCol = false;
                        else
                            sb.append(" AND");
                        sb.append(String.format(" %s = %s", parts[0].replaceAll("^\"|\"$", ""), parts[1]));
                    }
                }

                sb.append("\n");
            }

            System.out.println(sb.toString());
        } catch (IOException ex) {
            System.out.println("Ошибка чтения файла.");
        }
    }
}
