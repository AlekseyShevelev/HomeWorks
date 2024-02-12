package task3;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(1, "two");
        System.out.println(pair1.getFirst());
        System.out.println(pair1.getSecond());
        System.out.println(pair1);

        Pair<Boolean, Float> pair2 = new Pair<>(true, 3.14f);
        System.out.println(pair2.getFirst());
        System.out.println(pair2.getSecond());
        System.out.println(pair2);
    }
}
