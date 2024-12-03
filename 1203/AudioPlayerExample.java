package OpenChallenge8;

import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AudioPlayerExample {
    private static Clip audioClip;
    private static JLabel statusLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("오디오 플레이어");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu audioMenu = new JMenu("오디오");

        JMenuItem playMenuItem = new JMenuItem("연주");
        JMenuItem stopMenuItem = new JMenuItem("종료");

        statusLabel = new JLabel("오디오 파일을 선택하세요");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setFont(new Font("Serif", Font.PLAIN, 16));

        playMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    playAudio(selectedFile);
                }
            }
        });

        stopMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopAudio();
            }
        });

        audioMenu.add(playMenuItem);
        audioMenu.add(stopMenuItem);

        menuBar.add(audioMenu);

        frame.setJMenuBar(menuBar);

        frame.add(statusLabel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static void playAudio(File audioFile) {
        try {
            if (audioClip != null && audioClip.isRunning()) {
                audioClip.stop();
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
            audioClip.start();

            statusLabel.setText(audioFile.getName() + "를 연주하고 있습니다.");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            JOptionPane.showMessageDialog(null, "오디오 파일을 재생할 수 없습니다.", "에러", JOptionPane.ERROR_MESSAGE);
            statusLabel.setText("오디오 파일을 선택하세요");
        }
    }

    private static void stopAudio() {
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop();
            audioClip.close();
            statusLabel.setText("오디오 파일을 선택하세요");
        }
    }
}
