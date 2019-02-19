import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color startColor = new Color(red, green, blue);

        red = (int) (Math.random() * 255);
        green = (int) (Math.random() * 255);
        blue = (int) (Math.random() * 255);
        Color endColor = new Color(red, green, blue);

        GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);

    }
}

class TwoButtons {
    JFrame frame;
    JLabel label;

    //Inner Class:ColorListener
    class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.repaint();
        }
    }

    //Inner Class:LabelListener
    class LabelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String labelText = label.getText();
            labelText += "Ouch!";
            label.setText(labelText);
        }
    }

    void go() {
        frame = new JFrame();

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListener());

        label = new JLabel("I'm a label");

        MyDrawPanel drawPanel = new MyDrawPanel();
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        TwoButtons GUI3C = new TwoButtons();
        GUI3C.go();
    }
}