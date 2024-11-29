package OpenChallenge7;

import javax.swing.*;
import java.awt.*;

public class ColorGridLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("4x4 Color Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(4, 4));

        Color[] colors = {
            Color.WHITE, Color.GRAY, Color.RED, Color.GREEN,
            Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA,
            Color.PINK, Color.ORANGE, Color.LIGHT_GRAY, Color.DARK_GRAY,
            Color.BLACK, Color.RED, Color.MAGENTA, Color.PINK
        };
        
        for (int i = 0; i < 16; i++) {
            JLabel label = new JLabel(String.valueOf(i));
            label.setOpaque(true);
            label.setBackground(colors[i]);
            label.setForeground(Color.BLACK);
            label.setFont(new Font("Arial", Font.BOLD, 20));
            label.setHorizontalAlignment(SwingConstants.LEFT);
            label.setVerticalAlignment(SwingConstants.CENTER);

            contentPane.add(label);
        }
        
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
