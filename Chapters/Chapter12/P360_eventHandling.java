import javax.swing.*;
import java.awt.event.*;

class eventHandling implements ActionListener {
    JButton button;

    void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");
        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        button.setText("I've been clicked!");
    }

    public static void main(String[] args) {
        eventHandling gui = new eventHandling();
        gui.go();
    }
}