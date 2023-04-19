import java.util.Scanner;

/*
 * Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
 */

public class Task01 {
    public static void main(String[] args) {
        System.out.print("Ведите положительное число n: ");

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        int triangular = 0;
        long factorial = 1;

        for (int i = 1; i <= n; i++) {
            triangular += i;
            factorial *= i;
        }

        System.out.printf("%d-ое треугольное число = %d, %d! = %d\n", n, triangular, n, factorial);
    }
}
