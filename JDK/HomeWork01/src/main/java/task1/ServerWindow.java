package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame {
    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;

    private final JTextArea log = new JTextArea();
    private final JPanel pnlButtons = new JPanel(new GridLayout(1, 2));
    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");

    private boolean isServerWorking;

    public ServerWindow() {
        isServerWorking = false;
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

    public boolean isServerWorking() {
        return isServerWorking;
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
        return true;
    }
}
