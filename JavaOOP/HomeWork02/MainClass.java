public class MainClass {
    public static void main(String[] args) {
        Plate plate = new Plate(100);
        Cat[] cats = {
            new Cat("Барсик", 5),
            new Cat("Василий", 50),
            new Cat("Пушистик", 20),
            new Cat("Тимофей", 30),
            new Cat("Мурзик", 10)
        };

        feedingCats(plate, cats);

        plate.addFood(200);

        feedingCats(plate, cats);
    }
    
    private static void feedingCats(Plate plate, Cat[] cats) {
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.printf("Кот %s %s.\n", cat.getName(), (cat.isFull()) ? "сыт" : "голоден");
        }

        System.out.println("--------------");
    }
}