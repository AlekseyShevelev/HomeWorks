package messenger.client;

import messenger.server.ServerWindow;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class ClientWindow extends JFrame implements ClientView {
    private static final int POS_X = 100;
    private static final int POS_Y = 200;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 500;

    private final JPanel pnlTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfServer = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfUserName = new JTextField("User Name");
    private final JPasswordField pfUserPassword = new JPasswordField("12345678");
    private final JButton btnLogin = new JButton("Login");
    private final JTextArea log = new JTextArea();
    private final JPanel pnlBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("send");

    private Client client;

    public ClientWindow(ServerWindow serverWindow) {
        createPanel();
        setting(serverWindow);
        setVisible(true);
    }

    private void createPanel() {
        btnLogin.addActionListener(e -> connectToServer());
        tfMessage.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkMessage();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkMessage();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkMessage();
            }
        });
        btnSend.addActionListener(e -> sendMessage());

        pnlTop.add(tfServer);
        pnlTop.add(tfPort);
        pnlTop.add(new JLabel());
        pnlTop.add(tfUserName);
        pnlTop.add(pfUserPassword);
        pnlTop.add(btnLogin);
        add(pnlTop, BorderLayout.NORTH);

        log.setEnabled(false);
        log.setDisabledTextColor(Color.black);
        JScrollPane spLog = new JScrollPane(log);
        add(spLog);

        tfMessage.setEnabled(false);
        pnlBottom.add(tfMessage);
        btnSend.setEnabled(false);
        pnlBottom.add(btnSend, BorderLayout.EAST);
        add(pnlBottom, BorderLayout.SOUTH);

        getRootPane().setDefaultButton(btnSend);
    }

    private void setting(ServerWindow serverWindow) {
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat Client");
        setAlwaysOnTop(true);
        client = new Client(this, serverWindow.getServer());
    }

    private void checkMessage() {
        btnSend.setEnabled(!tfMessage.getText().isEmpty());
    }

    private void sendMessage() {
        String message = tfMessage.getText();

        if (!message.isBlank()) {
            client.sendMessage(message);
            tfMessage.setText("");
        }
    }

    private void setLoginMode() {
        pnlTop.setVisible(true);
        tfMessage.setEnabled(false);
        btnSend.setEnabled(false);
    }

    public String getUserName() {
        return tfUserName.getText();
    }

    public void connectToServer() {
        log.setText("");

        if (client.connectToServer(getUserName())) {
            pnlTop.setVisible(false);
            tfMessage.setEnabled(true);
            checkMessage();
        }
    }

    public void showMessage(String message) {
        log.append(message + "\n");
    }

    public void disconnectFromServer() {
        log.append("You disconnected from server.\n");
        setLoginMode();
    }
}
