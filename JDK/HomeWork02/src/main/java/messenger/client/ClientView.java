package messenger.client;

public interface ClientView {
    void connectToServer();
    void showMessage(String message);
    void disconnectFromServer();
}