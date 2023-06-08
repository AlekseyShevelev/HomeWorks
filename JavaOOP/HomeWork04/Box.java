import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public float getWeight() {
        return (fruits.isEmpty() ? 0 : fruits.size() * fruits.get(0).getWeight());
    }

    public void addFruit(T fruit) {
        this.fruits.add(fruit);
    }

    public void moveToOtherBox(Box<T> box) {
        System.out.printf("Пересыпаем фрукты из [%s] в [%s]...\n", this, box);

        while (!this.fruits.isEmpty()) {
            box.addFruit(this.fruits.remove(0));
        }
    }

    public boolean compare(Box<? extends Fruit> box) {
        return (box.getWeight() == this.getWeight());
    }

    @Override
    public String toString() {
        return (fruits.isEmpty() ? "Пустая коробка."
                : String.format("Коробка с \"%s\"; Количество: %d; Общий вес: %f.",
                        fruits.get(0).getName(),
                        fruits.size(),
                        this.getWeight()));
    }
}
