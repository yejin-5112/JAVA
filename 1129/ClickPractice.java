package OpenChallenge7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ClickPractice {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Click Practice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);

        JLabel label = new JLabel("C");
        label.setSize(50, 50);
        label.setLocation(100, 100);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Random rand = new Random();
                int x = 50 + rand.nextInt(350);
                int y = 50 + rand.nextInt(350);
                label.setLocation(x, y);
            }
        });

        frame.add(label);
        frame.setVisible(true);
    }
}
