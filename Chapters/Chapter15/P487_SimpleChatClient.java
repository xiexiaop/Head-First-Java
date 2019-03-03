import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SimpleChatClient {
    JTextField textField;
    PrintWriter writer;
    Socket sock;

    void go() {
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        textField = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(textField);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        setUpNetworking();
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    private void setUpNetworking() {
        try {
            sock = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.print("networking established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                writer.println(textField.getText());
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
            textField.setText("");
            textField.requestFocus();
        }
    }

    public static void main(String[] args) {
        new SimpleChatClient().go();
    }
}