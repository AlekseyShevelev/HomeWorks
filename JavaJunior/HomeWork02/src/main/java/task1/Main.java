package task1;

import java.util.Arrays;

public class Main {
    /*
    Используя Reflection API, напишите программу, которая выводит на экран все методы класса String.
     */
    public static void main(String[] args) {
        Arrays.stream(String.class.getMethods()).forEach(System.out::println);
    }
}
