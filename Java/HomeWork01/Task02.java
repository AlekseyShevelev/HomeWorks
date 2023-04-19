/*
 * Вывести все простые числа от 1 до 1000
 */

public class Task02 {
    public static void main(String[] args) {
        for (int i = 2; i <= 1000; i++) {
            boolean isSimple = true;

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isSimple = false;
                    break;
                }
            }

            if (isSimple) {
                System.out.printf("%d ", i);
            }
        }
        System.out.println();
    }
}
