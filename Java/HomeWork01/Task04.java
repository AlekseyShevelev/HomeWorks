/*
* Задано уравнение вида q + w = e, q, w, e >= 0.
* Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
* Требуется восстановить выражение до верного равенства.
* Предложить хотя бы одно решение или сообщить, что его нет.
 */

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        String q, w, e;

        Scanner scn = new Scanner(System.in);
        System.out.print("Ведите двузначные положительные числа q, w, e: ");
        q = scn.next();
        w = scn.next();
        e = scn.next();
        scn.close();

        int q1Min, q1Max, q2Min, q2Max, w1Min, w1Max, w2Min, w2Max, e1Min, e1Max, e2Min, e2Max; 

        if (q.charAt(0) == '?') {
            q1Min = 1;
            q1Max = 9;
        } else if (Character.isDigit(q.charAt(0))){
            q1Min = Integer.parseInt(q, 0, 1, 10);
            q1Max = q1Min;
        } else {
            System.out.println("Первое число введено неправильно!");
            return;
        }

        if (q.charAt(1) == '?') {
            q2Min = 0;
            q2Max = 9;
        } else if (Character.isDigit(q.charAt(1))){
            q2Min = Integer.parseInt(q, 1, 2, 10);
            q2Max = q2Min;
        } else {
            System.out.println("Первое число введено неправильно!");
            return;
        }

        if (w.charAt(0) == '?') {
            w1Min = 1;
            w1Max = 9;
        } else if (Character.isDigit(w.charAt(0))){
            w1Min = Integer.parseInt(w, 0, 1, 10);
            w1Max = w1Min;
        } else {
            System.out.println("Второе число введено неправильно!");
            return;
        }

        if (w.charAt(1) == '?') {
            w2Min = 0;
            w2Max = 9;
        } else if (Character.isDigit(w.charAt(1))){
            w2Min = Integer.parseInt(w, 1, 2, 10);
            w2Max = w2Min;
        } else {
            System.out.println("Второе число введено неправильно!");
            return;
        }

        if (e.charAt(0) == '?') {
            e1Min = 1;
            e1Max = 9;
        } else if (Character.isDigit(e.charAt(0))){
            e1Min = Integer.parseInt(e, 0, 1, 10);
            e1Max = e1Min;
        } else {
            System.out.println("Третье число введено неправильно!");
            return;
        }

        if (e.charAt(1) == '?') {
            e2Min = 0;
            e2Max = 9;
        } else if (Character.isDigit(e.charAt(1))){
            e2Min = Integer.parseInt(e, 1, 2, 10);
            e2Max = e2Min;
        } else {
            System.out.println("Третье число введено неправильно!");
            return;
        }

        String result = "";

        for (int q1 = q1Min; q1 <= q1Max; q1++) {
            for (int q2 = q2Min; q2 <= q2Max; q2++) {
                for (int w1 = w1Min; w1 <= w1Max; w1++) {
                    for (int w2 = w2Min; w2 <= w2Max; w2++) {
                        for (int e1 = e1Min; e1 <= e1Max; e1++) {
                            for (int e2 = e2Min; e2 <= e2Max; e2++) {
                                if ((q1 * 10 + q2) + (w1 * 10 + w2) == (e1 * 10 + e2)) {
                                    result = String.format("%d + %d = %d", q1 * 10 + q2, w1 * 10 + w2, e1 * 10 + e2);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (result.length() > 0)
            System.out.println(result);
        else
            System.out.println("Решения нет.");
    }
}
