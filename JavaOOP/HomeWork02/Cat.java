public class Cat {
    private String name;
    private int appetite;
    private boolean full;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.full = false;
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= appetite) {
            plate.setFood(plate.getFood() - appetite);
            full = true;
        }
        else {
            System.out.println("В тарелке мало еды!");
            full = false;
        }
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFull() {
        return full;
    }
}