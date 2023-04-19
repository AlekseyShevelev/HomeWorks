/*
 * Реализовать простой калькулятор
 */

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        double number1, number2, result;
        char operation;

        Scanner scn = new Scanner(System.in);
        System.out.print("Ведите два числа: ");
        number1 = scn.nextDouble();
        number2 = scn.nextDouble();
        System.out.print("Ведите операцию ('+', '-', '*', '/'): ");
        operation = scn.next().charAt(0);
        scn.close();

        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
            if (number2 == 0) {
                System.out.println("Ошибка деления на 0!");
                return;
            } else {
                result = number1 / number2;
                break;
            }
            default:
                System.out.println("Вы ввели некорректную операцию!");
                return;
        }

        System.out.printf("%f %c %f = %f", number1, operation, number2, result);
    }
}
