/*
Если необходимо, исправьте данный код
(задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
*/

public class Task02 {
    public static void main(String[] args) {
        try {
            int d = 0;
            int[] intArray = new int[]{1, 2, 3};

            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching Array Index exception: " + e);
        } catch (ArithmeticException e) {
            System.out.println("Catching Arithmetic exception: " + e);
        }
    }
}
