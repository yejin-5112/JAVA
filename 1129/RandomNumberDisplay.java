package OpenChallenge7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomNumberDisplay {
    public static void main(String[] args) {
        JFrame frame = new JFrame("West Grid 프레임");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridLayout(10, 1));
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton("");
            button.setPreferredSize(new Dimension(50, 50));
            button.setBackground(new Color((int) (Math.random() * 0x1000000)));
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setText(" ");

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Color backgroundColor = button.getBackground();
                    for (Component c : contentPane.getComponents()) {
                        if (c instanceof JPanel) {
                            JPanel numberPanel = (JPanel) c;
                            for (Component label : numberPanel.getComponents()) {
                                if (label instanceof JLabel) {
                                    ((JLabel) label).setForeground(backgroundColor);
                                }
                            }
                        }
                    }
                }
            });

            buttonPanel.add(button);
        }

        JPanel numberPanel = new JPanel(null);
        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel(String.valueOf(new Random().nextInt(10)));
            label.setSize(50, 50);
            int x = 50 + new Random().nextInt(151);
            int y = 50 + new Random().nextInt(151);
            label.setLocation(x, y);
            label.setForeground(Color.BLACK);
            numberPanel.add(label);
        }

        contentPane.add(buttonPanel, BorderLayout.WEST);
        contentPane.add(numberPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
