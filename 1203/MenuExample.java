package OpenChallenge8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("메뉴 예제");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("파일");
        JMenu editMenu = new JMenu("편집");
        JMenu viewMenu = new JMenu("보기");
        JMenu inputMenu = new JMenu("입력");

        JMenuItem zoomMenuItem = new JMenuItem("화면확대");
        JMenuItem outlineMenuItem = new JMenuItem("쪽윤곽");

        zoomMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "화면확대 선택됨");
            }
        });

        outlineMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "쪽윤곽 선택됨");
            }
        });

        viewMenu.add(zoomMenuItem);
        viewMenu.add(outlineMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(inputMenu);

        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }
}
