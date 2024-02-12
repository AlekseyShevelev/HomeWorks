package task1;

/*
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
sum(), multiply(), divide(), subtract().
Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
 */
public class Calculator {
    public static <T1 extends Number, T2 extends Number> Number sum(T1 arg1, T2 arg2) {
        //Byte, Double, Float, Integer, Long и Short
        if (arg1 instanceof Double || arg2 instanceof Double) {
            return arg1.doubleValue() + arg2.doubleValue();
        }
        return null;
    }

    public static <T1 extends Number, T2 extends Number> Number multiply(T1 arg1, T2 arg2) {
        if (arg1 instanceof Double || arg2 instanceof Double) {
            return arg1.doubleValue() * arg2.doubleValue();
        }
        return null;
    }

    public static <T1 extends Number, T2 extends Number> Number divide(T1 arg1, T2 arg2) {
        if (arg1 instanceof Double || arg2 instanceof Double) {
            return arg1.doubleValue() / arg2.doubleValue();
        }
        return null;
    }

    public static <T1 extends Number, T2 extends Number> Number subtract(T1 arg1, T2 arg2) {
        if (arg1 instanceof Double || arg2 instanceof Double) {
            return arg1.doubleValue() - arg2.doubleValue();
        }
        return null;
    }
}
