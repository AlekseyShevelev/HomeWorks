package chat.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable {
    public final static ArrayList<ClientManager> clients = new ArrayList<>();
    private Socket socket;
    private String name;
    private BufferedReader reader;
    private BufferedWriter writer;

    public ClientManager(Socket socket) {
        try {
            this.socket = socket;
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            name = reader.readLine();
            clients.add(this);
            System.out.println(name + " подключился к чату.");
            broadcastMessage("Server: " + name + " подключился к чату.");
        } catch (IOException e) {
            closeEverything(socket, reader, writer);
        }
    }

    private void closeEverything(Socket socket, BufferedReader reader, BufferedWriter writer) {
        removeClient();
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

    private void removeClient() {
        clients.remove(this);
        System.out.println(name + " покинул чат.");
        broadcastMessage("Server: " + name + " покинул чат.");
    }

    private void sendMessage(String message) {
        boolean isPersonal = false;
        String[] words = message.split(" ");

        if (words.length > 0) {
            if (words[0].startsWith("@")) {
                for (ClientManager client : clients) {
                    if (client.name.equals(words[0].substring(1))) {
                        if (message.length() > words[0].length() + 1) {
                            message = message.substring(words[0].length() + 1);
                        } else {
                            message = "";
                        }

                        try {
                            client.writer.write(name + ": " + message);
                            client.writer.newLine();
                            client.writer.flush();
                        } catch (IOException e) {
                            closeEverything(socket, reader, writer);
                            break;
                        }
                        isPersonal = true;
                        break;
                    }
                }
            }
        }

        if (!isPersonal) {
            broadcastMessage(name + ": " + message);
        }
    }

    private void broadcastMessage(String message) {
        for (ClientManager client : clients) {
            if (!client.name.equals(name)) {
                try {
                    client.writer.write(message);
                    client.writer.newLine();
                    client.writer.flush();
                } catch (IOException e) {
                    closeEverything(socket, reader, writer);
                    break;
                }
            }
        }
    }

    @Override
    public void run() {
        while (socket.isConnected()) {
            try {
                sendMessage(reader.readLine());
            } catch (IOException e) {
                closeEverything(socket, reader, writer);
                break;
            }
        }
    }
}
