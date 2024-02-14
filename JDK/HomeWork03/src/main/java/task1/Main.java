package task1;

public class Main {
    public static void main(String[] args) {
        System.out.println(Calculator.sum(3.5d, 7.7d));
        System.out.println(Calculator.sum(3, 5));

        System.out.println(Calculator.multiply(3.5d, 7.7d));
        System.out.println(Calculator.multiply(3, 5));

        System.out.println(Calculator.divide(3.5d, 7.7d));
        System.out.println(Calculator.divide(3, 5));

        System.out.println(Calculator.subtract(3.5d, 7.7d));
        System.out.println(Calculator.subtract(3, 5));

        System.out.println(Calculator.divide(5, 0));
    }
}
