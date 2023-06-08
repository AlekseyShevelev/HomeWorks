/**
 Домашняя работа, задача:
========================

a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можно использовать ArrayList;
d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
Можно сравнивать коробки с яблоками и апельсинами;
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
g. Не забываем про метод добавления фрукта в коробку.
*/

public class Program {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Orange orange = new Orange();

        Box<Apple> box1 = new Box<>();
        box1.addFruit(apple);       
        box1.addFruit(apple);
        System.out.println(box1);

        Box<Orange> box2 = new Box<>();
        box2.addFruit(orange);
        box2.addFruit(orange);
        box2.addFruit(orange);
        System.out.println(box2);

        Box<Apple> box3 = new Box<>();
        box3.addFruit(apple);
        box3.addFruit(apple);
        box3.addFruit(apple);
        System.out.println(box3);

        Box<Orange> box4 = new Box<>();
        box4.addFruit(orange);
        box4.addFruit(orange);
        box4.addFruit(orange);
        System.out.println(box4);

        System.out.println("--------------");
        System.out.printf("Коробки [%s] и [%s]%s равны по весу.\n", box2, box3, box2.compare(box3) ? "" : " не");
        System.out.printf("Коробки [%s] и [%s]%s равны по весу.\n", box2, box4, box2.compare(box4) ? "" : " не");

        System.out.println("--------------");
        box2.moveToOtherBox(box4);
        System.out.println(box1);
        System.out.println(box2);
        System.out.println(box3);
        System.out.println(box4);
    }
}
