import java.util.Scanner;

public class OrderLoader {
    private static Scanner scanner = new Scanner(System.in, "cp866");
    private final Order order;

    public OrderLoader(Order order) {
        this.order = order;
    }

    public void inputFromConsole() {
        order.setClientName(prompt("Имя клиента: "));
        order.setProduct(prompt("Продукт: "));
        order.setQnt(Integer.parseInt(prompt("Кол-во: ")));
        order.setPrice(Integer.parseInt(prompt("Цена: ")));
    }

    private String prompt(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
