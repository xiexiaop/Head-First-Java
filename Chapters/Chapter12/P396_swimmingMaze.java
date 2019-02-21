import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Animate {
    int x = 1;
    int y = 1;

    void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawP drawP = new MyDrawP();
        frame.getContentPane().add(drawP);
        frame.setSize(500, 500);
        frame.setVisible(true);
        for (int i = 0; i < 124; i++, x++, y++) {
            x++;
            drawP.repaint();
            try {
                Thread.sleep(50);
            } catch (Exception ex) {
                // TODO: handle exception
            }
        }
    }

    class MyDrawP extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.blue);
            g.fillRect(x, y, 500 - x * 2, 500 - y * 2);
        }
    }

    public static void main(String[] args) {
        Animate gui = new Animate();
        gui.go();
    }
}