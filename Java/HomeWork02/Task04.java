/*
 * К калькулятору из предыдущего дз добавить логирование.
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task04 {
    public static void main(String[] args) throws IOException {
        double number1, number2, result = 0;
        char operation;
        String error = "";

        Scanner scn = new Scanner(System.in);
        System.out.print("Ведите два числа: ");
        number1 = scn.nextDouble();
        number2 = scn.nextDouble();
        System.out.print("Ведите операцию ('+', '-', '*', '/'): ");
        operation = scn.next().charAt(0);
        scn.close();

        Logger logger = Logger.getLogger(Task02.class.getName());
        FileHandler fh = new FileHandler("log04.txt");
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        logger.addHandler(fh);

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
                    error = "Ошибка деления на 0!";
                    break;
                } else {
                    result = number1 / number2;
                    break;
                }
            default:
                error = "Вы ввели некорректную операцию!";
                break;
        }

        if (error.length() > 0) {
            System.out.println(error);
            logger.log(Level.SEVERE, error);
        } else {
            String resultText = String.format("%f %c %f = %f", number1, operation, number2, result);
            System.out.println(resultText);
            logger.log(Level.INFO, resultText);
        }
    }
}
