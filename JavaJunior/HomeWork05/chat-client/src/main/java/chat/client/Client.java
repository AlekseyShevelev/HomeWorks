package chat.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final Socket socket;
    private final String name;
    private BufferedReader reader;
    private BufferedWriter writer;

    public Client(Socket socket, String name) {
        this.socket = socket;
        this.name = name;

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            closeEverything(socket, reader, writer);
        }
    }

    private void closeEverything(Socket socket, BufferedReader reader, BufferedWriter writer) {
        try {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listenForMessage() {
        new Thread(() -> {
            while (socket.isConnected()) {
                try {
                    System.out.println(reader.readLine());
                } catch (IOException e) {
                    closeEverything(socket, reader, writer);
                }
            }
        }).start();
    }

    public void sendMessage() {
        try {
            writer.write(name);
            writer.newLine();
            writer.flush();

            Scanner scanner = new Scanner(System.in);
            while (socket.isConnected()) {
                String message = scanner.nextLine();
                writer.write(message);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            closeEverything(socket, reader, writer);
        }
    }
}
