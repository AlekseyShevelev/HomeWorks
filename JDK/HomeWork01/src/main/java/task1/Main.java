package task1;

public class Main {
    public static void main(String[] args) {
        ServerWindow server = new ServerWindow();
        new ClientWindow(server);
        new ClientWindow(server);
    }
}
