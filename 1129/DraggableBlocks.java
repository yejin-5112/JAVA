package OpenChallenge7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class DraggableBlocks {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Draggable Blocks");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(null);

        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 600, 600);
        frame.add(panel);

        java.util.List<JLabel> blocks = new java.util.ArrayList<>();
        int[] offsetX = new int[1];
        int[] offsetY = new int[1];

        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_M) {
                    JLabel block = new JLabel();
                    block.setSize(80, 80);
                    block.setOpaque(true);
                    block.setBackground(new Color(new Random().nextInt(0x1000000)));
                    block.setLocation(100, 100);

                    block.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            offsetX[0] = e.getX();
                            offsetY[0] = e.getY();
                        }
                    });

                    block.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            int newX = block.getX() + e.getX() - offsetX[0];
                            int newY = block.getY() + e.getY() - offsetY[0];
                            block.setLocation(newX, newY);
                        }
                    });

                    panel.add(block, 0);
                    blocks.add(block);
                    panel.repaint();
                }
            }
        });

        panel.setFocusable(true);
        panel.requestFocusInWindow();

        frame.setVisible(true);
    }
}
