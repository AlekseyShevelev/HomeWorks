package task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите N: ");
        int n = scn.nextInt();
        printMultiplicationTable(n);
        scn.close();
    }

    private static void printMultiplicationTable(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.printf("%d * %d = %d\n", i, j, i*j);
            }
            System.out.println();
        }
    }
}
