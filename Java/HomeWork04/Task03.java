import java.util.Scanner;
import java.util.Stack;

/*
 * Напишите постфиксный калькулятор.
 * Пользователь вводит данные и операции в обратной польской записи.
 * Калькулятор вычисляет результат и проверяет, что в стэке получилось единственное число.
 */

public class Task03 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Stack<Integer> storage = new Stack<>();

        System.out.println("Введите данные для калькулятора: ");
        String[] data = scn.nextLine().split(" ");

        scn.close();

        for (String str : data) {
            if (isNumber(str)) {
                storage.push(Integer.parseInt(str));
            } else if (storage.size() < 2) {
                System.out.println("Ошибка в исходных данных!");
                return;
            } else {
                int operand1, operand2;
                operand2 = storage.pop();
                operand1 = storage.pop();

                switch (str) {
                    case "+":
                        storage.push(operand1 + operand2);
                        break;

                    case "-":
                        storage.push(operand1 - operand2);
                        break;

                    case "*":
                        storage.push(operand1 * operand2);
                        break;

                    case "/":
                        storage.push(operand1 / operand2);
                        break;

                    default:
                        System.out.println("Неверная операция!");
                        return;
                }
            }
        }

        if (storage.size() != 1)
            System.out.println("Ошибка в исходных данных!");
        else
            System.out.println(storage.pop());
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
