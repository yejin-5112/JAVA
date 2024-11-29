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

        JLabel label = new JLabel("100"); // 초기 레이블 값 설정 (슬라이더 값만 표시)
        label.setFont(new Font("Arial", Font.BOLD, 18));  // 글꼴을 굵게 설정
        label.setOpaque(true);             // 배경색을 표시하도록 불투명하게 설정
        label.setBackground(Color.GREEN); // 배경색을 노란색으로 설정
        label.setForeground(Color.BLACK);   // 글자 색을 빨간색으로 설정
        label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // 여백 추가

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue(); // 슬라이더 값 가져오기
                label.setText(String.valueOf(value)); // 레이블에 슬라이더 값만 표시
            }
        });

        frame.add(slider);
        frame.add(label);

        frame.setVisible(true);
    }
}
