package task1;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return (double) a / b;
    }

    public double calculateDiscount(double amount, int discount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма покупки должна быть положительным числом.");
        }

        if (discount <= 0 || discount >= 100) {
            throw new IllegalArgumentException("Скидка должна быть больше 0 и меньше 100.");
        }

        return amount * (1 - discount / 100.0);
    }
}
