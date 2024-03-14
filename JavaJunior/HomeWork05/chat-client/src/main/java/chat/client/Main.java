package chat.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите своё имя: ");
        String name = scanner.nextLine();

        try {
            Socket socket = new Socket("localhost", 1400);
            Client client = new Client(socket, name);
            client.listenForMessage();
            client.sendMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
