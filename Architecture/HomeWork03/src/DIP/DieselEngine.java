package DIP;

public class DieselEngine implements IEngine {
    @Override
    public void start() {
        System.out.println("Запуск дизельного двигателя...");
    }
}
