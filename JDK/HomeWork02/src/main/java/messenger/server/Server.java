package messenger.server;

import messenger.client.Client;
import messenger.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private boolean isServerWorking;

    private final ServerView serverView;
    private final Repository repository;
    private final List<Client> clients;

    public Server(ServerView serverView, Repository repository) {
        isServerWorking = false;
        this.serverView = serverView;
        this.repository = repository;
        this.clients = new ArrayList<>();
    }

    private void showOnWindow(String text) {
        serverView.showMessage(text);
    }

    private void showWarning(String text) {
        serverView.showWarning(text);
    }

    public void startServer() {
        if (isServerWorking) {
            showWarning("Server already started.");
        } else {
            isServerWorking = true;
            showOnWindow("Server started...\n");
        }
    }

    public void stopServer() {
        if (!isServerWorking) {
            showWarning("Server already stopped.");
        } else {
            isServerWorking = false;

            while (!clients.isEmpty()) {
                clients.get(0).disconnectFromServer();
                clients.remove(0);
            }

            showOnWindow("Server stopped...\n");
        }
    }

    public boolean connect(Client client) {
        if (!isServerWorking) {
            return false;
        }
        clients.add(client);
        showOnWindow(client.getName() + " connected.");
        return true;
    }

    public String getHistory() {
        return repository.getLog();
    }

    public void sendMessage(String userName, String message) {
        String text = userName + ": " + message;

        if (!isServerWorking || !repository.addToLog(text)) {
            return;
        }

        showOnWindow(text);

        for (Client client : clients) {
            client.receiveMessage(text);
        }
    }
}
