import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        Product bottleOfWater1 = new BottleOfWater("Чистый Источник", "Бутылка с водой #1", 45, 0.5);
        System.out.println(bottleOfWater1.displayInfo());

        Product bottleOfWater2 = new BottleOfWater("Чистый Источник", "Бутылка с водой #2", 90, 1.0);
        System.out.println(bottleOfWater2.displayInfo());

        Product bottleOfMilk1 = new BottleOfMilk("Веселый молочник", "Бутылка с молоком #1", 80.5, 0.9, 5);
        System.out.println(bottleOfMilk1.displayInfo());

        Product chocolate1 = new Chocolate("РотФронт", "Шоколад #1", 120.5, Chocolate.Type.Dark, 450);
        System.out.println(chocolate1.displayInfo());

        List<Product> products = new ArrayList<>();
        products.add(bottleOfWater1);
        products.add(bottleOfWater2);
        products.add(bottleOfMilk1);
        products.add(chocolate1);

        VendingMachine vendingMachine = new VendingMachine(products);

        BottleOfWater bottleOfWaterResult = vendingMachine.getBottleOfWater(1.5);

        if (bottleOfWaterResult != null) {
            System.out.println("Вы купили:");
            System.out.println(bottleOfWaterResult.displayInfo());
        } else {
            System.out.println("Такой бутылки с водой нет в автомате.");
        }

        Chocolate chocolateResult = vendingMachine.getChocolate(Chocolate.Type.Milk);

        if (chocolateResult != null) {
            System.out.println("Вы купили:");
            System.out.println(chocolateResult.displayInfo());
        } else {
            System.out.println("Такого шоколада нет в автомате.");
        }

        chocolateResult = vendingMachine.getChocolate(Chocolate.Type.Dark);

        if (chocolateResult != null) {
            System.out.println("Вы купили:");
            System.out.println(chocolateResult.displayInfo());
        } else {
            System.out.println("Такого шоколада нет в автомате.");
        }
    }
}
