package OpenChallenge7;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class SliderExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Slider Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);  
        frame.setLayout(new FlowLayout());

        JSlider slider = new JSlider(100, 200); 
        slider.setPreferredSize(new Dimension(400, 50));  
        slider.setMajorTickSpacing(20);   
        slider.setMinorTickSpacing(1);    
        slider.setPaintTicks(true);       
        slider.setPaintLabels(true);     
        slider.setValue(100);             

        JLabel label = new JLabel("100");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setOpaque(true);
        label.setBackground(Color.GREEN);
        label.setForeground(Color.BLACK);
        label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                label.setText(String.valueOf(value));
            }
        });

        frame.add(slider);
        frame.add(label);

        frame.setVisible(true);
    }
}
