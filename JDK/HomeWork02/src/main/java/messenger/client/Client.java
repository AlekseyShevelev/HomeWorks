package messenger.client;

import messenger.server.Server;

public class Client {
    private String name;
    private Boolean connected;
    private final ClientView clientView;
    private final Server server;

    public Client(ClientView clientView, Server server) {
        this.clientView = clientView;
        this.server = server;
    }

    private void showOnWindow(String text) {
        clientView.showMessage(text);
    }

    Boolean connectToServer(String name) {
        this.name = name;
        if (server.connect(this)) {
            connected = true;
            showOnWindow("Successfully connected to the server.\n");
            String log = server.getHistory().trim();
            if (!log.isEmpty()) {
                showOnWindow(log);
            }
            return true;
        }
        else {
            showOnWindow("Server connection error.");
            return false;
        }
    }

    public void sendMessage(String text) {
        if (connected) {
            if (!text.isEmpty()) {
                server.sendMessage(name, text);
            }
        } else {
            showOnWindow("There is no connection to the server.");
        }
    }

    public void receiveMessage(String message) {
        showOnWindow(message);
    }

    public void disconnectFromServer() {
        if (connected) {
            connected = false;
            clientView.disconnectFromServer();
        }
    }

    public String getName() {
        return name;
    }
}
