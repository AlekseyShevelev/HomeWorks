package DIP;

public class PetrolEngine implements IEngine {
    @Override
    public void start() {
        System.out.println("Запуск бензинового двигателя...");
    }
}
