/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
Фамилия Имя Отчество номертелефона

Форматы данных:
фамилия, имя, отчество - строки
номертелефона - целое беззнаковое число без форматирования

Ввод всех элементов через пробел

Приложение должно проверить введенные данные по количеству.
Если количество не совпадает с требуемым, вернуть код ошибки,
обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
Можно использовать встроенные типы java и создать свои.
Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><номер_телефона>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    static Scanner scn = new Scanner(System.in, "cp866");
    static int PARAM_COUNT = 4;

    public static void main(String[] args) {
        while (true) {
            try {
                Client client = getClient();
                if (client == null) {
                    return;
                }
                saveClient(client);
            } catch (IncorrectParametersException e) {
                System.out.println("Ошибка ввода данных: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ошибка записи в файл: " + e.getMessage());
            }
        }
    }

    private static Client getClient() throws IncorrectParametersException {
        Client result = null;

        System.out.println("Введите Фамилию Имя Отчество Телефон (пустая строка - выход): ");
        String inputStr = scn.nextLine();
        if (inputStr.isEmpty()) {
            return null;
        }
        String[] data = inputStr.split(" ");

        if (data.length > PARAM_COUNT) {
            throw new IncorrectParametersException(String.format("Параметров больше, чем надо (%d вместо %d)", data.length, PARAM_COUNT));
        } else if (data.length < PARAM_COUNT) {
            throw new IncorrectParametersException(String.format("Параметров меньше, чем надо (%d вместо %d)", data.length, PARAM_COUNT));
        } else if (!data[0].matches("\\p{L}+")) {
            throw new IncorrectParametersException("Неверный формат параметра 1");
        } else if (!data[1].matches("\\p{L}+")) {
            throw new IncorrectParametersException("Неверный формат параметра 2");
        } else if (!data[2].matches("\\p{L}+")) {
            throw new IncorrectParametersException("Неверный формат параметра 3");
        } else if (!data[3].matches("\\d+")) {
            throw new IncorrectParametersException("Неверный формат параметра 4");
        } else {
            try {
                result = new Client(data[0], data[1], data[2], Integer.parseUnsignedInt(data[3]));
            } catch (NumberFormatException e) {
                throw new IncorrectParametersException("Неверный формат параметра 4");
            }
        }

        return result;
    }

    private static void saveClient(Client client) throws SaveToFileException {
        String fileName = String.format("%s.txt", client.getLastName());

        try (FileWriter file = new FileWriter(fileName, true);) {
            if (new File(fileName).length() > 0) {
                file.write('\n');
            }
            file.write(client.toString());
            file.flush();
            System.out.printf("*** Пользователь записан в файл %s.\n", fileName);
        } catch (IOException e) {
            throw new SaveToFileException(e.getMessage());
        }
    }
}

class IncorrectParametersException extends Exception {
    public IncorrectParametersException(String message) {
        super(message);
    }
}

class SaveToFileException extends IOException {
    public SaveToFileException(String message) {
        super(message);
    }
}