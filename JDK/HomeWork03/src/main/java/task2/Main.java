package task2;

public class Main {
    public static void main(String[] args) {
        Object[] arr1 = {1, "two", 3};
        Object[] arr2 = {4, "five", 6};
        Object[] arr3 = {"one", 2, 3};
        Object[] arr4 = {7, "eight"};

        System.out.println(compareArrays(arr1, arr2));
        System.out.println(compareArrays(arr1, arr3));
        System.out.println(compareArrays(arr1, arr4));
    }

    /*
    Напишите обобщенный метод compareArrays(), который принимает два массива
    и возвращает true, если они одинаковые, и false в противном случае.
    Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
     */
    public static <T> boolean compareArrays(T[] array1, T[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].getClass().equals(array2[i].getClass())) {
                return false;
            }
        }

        return true;
    }
}
