package task1;

/*
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
sum(), multiply(), divide(), subtract().
Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
 */
public class Calculator {
    public static <T extends Number> Number sum(T arg1, T arg2) {
        return arg1.doubleValue() + arg2.doubleValue();
    }

    public static <T extends Number> Number multiply(T arg1, T arg2) {
        return arg1.doubleValue() * arg2.doubleValue();
    }

    public static <T extends Number> Number divide(T arg1, T arg2) {
        if(arg2.doubleValue() == 0) {
            throw new ArithmeticException("Деление на 0 запрещено.");
        }
        return arg1.doubleValue() / arg2.doubleValue();
    }

    public static <T extends Number> Number subtract(T arg1, T arg2) {
        return arg1.doubleValue() - arg2.doubleValue();
    }
}
