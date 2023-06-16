public class Program {
    public static void main(String[] args) {
        Order order1 = new Order("ООО \"Рога и Копыта\"", "Стул", 2, 500);
        System.out.println(order1);

        Order order2 = new Order();
        
        OrderLoader loader = new OrderLoader(order2);
        loader.inputFromConsole();
        System.out.println(order2);

        OrderSaver saver = new OrderSaver(order2);
        saver.saveToJson("order2.json");
    }
}
