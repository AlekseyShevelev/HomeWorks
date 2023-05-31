public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        if (food < 0) {
            throw new IllegalStateException("Количество еды не может быть отрицательным.");
        }
        this.food = food;
    }

    public void addFood(int food) {
        this.food += food;
    }
}