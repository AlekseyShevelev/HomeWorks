package messenger.server;

import messenger.repository.LogFile;

import javax.swing.*;
import java.awt.*;

public class ServerWindow extends JFrame implements ServerView {
    private static final int POS_X = 500;
    private static final int POS_Y = 100;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;

    private final JTextArea log = new JTextArea();
    private final JPanel pnlButtons = new JPanel(new GridLayout(1, 2));
    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");

    Server server;

    public ServerWindow() {
        setting();
        createPanel();
        setVisible(true);
    }

    private void createPanel() {
        btnStart.addActionListener(e -> server.startServer());
        btnStop.addActionListener(e -> server.stopServer());

        log.setEnabled(false);
        log.setDisabledTextColor(Color.black);
        JScrollPane spLog = new JScrollPane(log);
        add(spLog);

        pnlButtons.add(btnStart);
        pnlButtons.add(btnStop);
        add(pnlButtons, BorderLayout.SOUTH);
    }

    private void setting() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat Server");
        setAlwaysOnTop(true);
        server = new Server(this, new LogFile());
    }

    public void showMessage(String message) {
        log.append(message + "\n");
    }

    public void showWarning(String text) {
        JOptionPane.showMessageDialog(log, text);
    }

    public Server getServer() {
        return server;
    }
}
