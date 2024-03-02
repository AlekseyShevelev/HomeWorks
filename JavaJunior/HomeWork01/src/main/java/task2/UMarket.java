package task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class UMarket {
    private final Collection<Thing> things;

    public UMarket() {
        this.things = new ArrayList<>();
        initializeThings();
    }

    public <T extends Thing> Collection<T> getThings(Class<T> clazz) {
        return things.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .toList();
    }

    public <T extends Thing> T getThingByIndex(Class<T> clazz, int index) {
        AtomicInteger counter = new AtomicInteger(1);
        return things.stream()
                .filter(clazz::isInstance)
                .filter(thing -> index == counter.getAndIncrement())
                .map(clazz::cast)
                .findFirst()
                .orElse(null);
    }

    public <T extends Thing> void printThings(Class<T> clazz) {
//        int index = 1;
//        for (Thing thing : things) {
//            if (clazz.isInstance(thing)) {
//                //if (Food.class.isAssignableFrom(thing.getClass())) {
//                if (thing instanceof Food) {
//                    System.out.printf("[%d] %s (Белки: %s, Жиры: %s, Углеводы: %s)\n",
//                            index++,
//                            thing.getName(),
//                            ((Food) thing).getProteins(),
//                            ((Food) thing).getFats(),
//                            ((Food) thing).getCarbohydrates());
//                } else {
//                    System.out.printf("[%d] %s\n", index++, thing.getName());
//                }
//            }
//        }

        int[] index = {1};

        things.stream()
                .filter(clazz::isInstance)
                .forEach(thing -> {
                    if (thing instanceof Food) {
                        System.out.printf("[%d] %s (Белки: %s, Жиры: %s, Углеводы: %s)\n",
                                index[0]++,
                                thing.getName(),
                                ((Food) thing).getProteins() ? "Да" : "Нет",
                                ((Food) thing).getFats() ? "Да" : "Нет",
                                ((Food) thing).getCarbohydrates() ? "Да" : "Нет");
                    } else {
                        System.out.printf("[%d] %s\n", index[0]++, thing.getName());
                    }
                });
    }

    private void initializeThings() {
        things.add(new Pen());
        things.add(new Notebook());

        things.add(new Chicken());
        things.add(new Fruit());
        things.add(new OliveOil());

        things.add(new BalykCheese());
        things.add(new Crisp());
        things.add(new ChocolateBar());

        things.add(new DumplingsBerry());
        things.add(new DumplingsMeat());
        things.add(new Cheburek());
    }
}
