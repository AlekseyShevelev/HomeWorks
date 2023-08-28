/*
Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
*/

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        try {
            System.out.println("Пользователь ввел строку: " + getString());
        } catch (EmptyStringException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static String getString() throws EmptyStringException {
        String result;
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите непустую строку: ");
        result = scn.nextLine();
        scn.close();
        if (result.isEmpty()) {
            throw new EmptyStringException("Нельзя вводить пустые строки.");
        }
        return result;
    }
}

class EmptyStringException extends Exception {
    public EmptyStringException(String message) {
        super(message);
    }
}
