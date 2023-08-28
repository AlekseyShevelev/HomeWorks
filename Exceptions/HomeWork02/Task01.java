import java.util.Scanner;

/*
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
и возвращает введенное значение.
Ввод текста вместо числа не должно приводить к падению приложения,
вместо этого, необходимо повторно запросить у пользователя ввод данных.
*/
public class Task01 {
    public static void main(String[] args) {
        System.out.printf("Введено число %f.\n", getNumber());
    }

    private static float getNumber() {
        Scanner scn = new Scanner(System.in);
        boolean isNeedInput = true;
        Float result = null;

        while (isNeedInput) {
            try {
                System.out.println("Ведите дробное число:");
                result = Float.parseFloat(scn.nextLine());

                isNeedInput = false;
            }
            catch (NumberFormatException e) {
                System.out.println("Введено некорректное число.");
            }
        }

        return result;
    }
}
