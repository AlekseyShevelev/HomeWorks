package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 100;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;

    private final JTextArea log = new JTextArea();
    private final JPanel pnlButtons = new JPanel(new GridLayout(1, 2));
    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");

    private boolean isServerWorking;

    private List<ClientWindow> clients;

    public ServerWindow() {
        isServerWorking = false;
        clients = new ArrayList<>();

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    JOptionPane.showMessageDialog(log,
                            "Server already started.");
                    return;
                }
                isServerWorking = true;
                log.setText("Server started...\n");
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    JOptionPane.showMessageDialog(log,
                            "Server already stopped.");
                    return;
                }
                isServerWorking = false;
                log.append("Server stopped...\n");
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat Server");
        setAlwaysOnTop(true);

        log.setEnabled(false);
        log.setDisabledTextColor(Color.black);
        JScrollPane spLog = new JScrollPane(log);
        add(spLog);

        pnlButtons.add(btnStart);
        pnlButtons.add(btnStop);
        add(pnlButtons, BorderLayout.SOUTH);

        setVisible(true);
    }

    public boolean connect(ClientWindow client) {
        if (!isServerWorking) {
            return false;
        }
        clients.add(client);
        log.append(client.getUserName() + " connected.\n");
        return true;
    }

    public String getHistory() {
        return LogFile.getLog();
    }

    public boolean sendMessage(String userName, String message) {
        String text = userName + ": " + message + "\n";

        if (!isServerWorking || !LogFile.addToLog(text)) {
            return false;
        }

        log.append(text);

        for (ClientWindow client : clients) {
            client.receiveMessage(text);
        }

        return true;
    }
}
