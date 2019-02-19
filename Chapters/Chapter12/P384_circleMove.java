import javax.swing.*;
import java.awt.*;

class simpleAnimation {
    int x = 70;
    int y = 70;

    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.green);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            g.setColor(Color.black);
            g.fillOval(x, y, 40, 40);
        }
    }

    void go() {
        JFrame frame = new JFrame();
        MyDrawPanel drawPanel = new MyDrawPanel();
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);

        for (int i = 0; i < 1500; i++) {
            x++;
            y++;
            drawPanel.repaint();
            try {
                Thread.sleep(50);
            } catch (Exception exception) {
                // TODO: handle exception
            }
        }
    }

    public static void main(String[] args) {
        simpleAnimation gui = new simpleAnimation();
        gui.go();
    }
}