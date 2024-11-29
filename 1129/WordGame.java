package OpenChallenge7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;

public class WordGame {
    private static final String[] sentences = {
        "Java is fun to learn.",
        "I love programming.",
        "Swing is a great library for GUIs.",
        "This is a simple word game.",
        "Challenge yourself with coding."
    };

    private JFrame frame;
    private JPanel wordPanel;
    private JLabel resultLabel;
    private JLabel sentenceLabel;
    private ArrayList<JLabel> wordLabels;
    private String currentSentence;
    private StringBuilder userSentence;
    private javax.swing.Timer timer;
    private int seconds;
    private JLabel timerLabel;
    private JButton newTextButton;
    private JLabel clickedWordsLabel;
    private JPanel bottomPanel;
    private int clickedWordsCount;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WordGame().startGame());
    }

    public void startGame() {
        frame = new JFrame("Word Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Create a panel for the top section with title and "New Text" button
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sentenceLabel = new JLabel("단어 조합 게임! 순서대로 단어를 클릭하세요~~");
        sentenceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        newTextButton = new JButton("New Text");
        newTextButton.addActionListener(e -> startNewText());
        topPanel.add(sentenceLabel);
        topPanel.add(newTextButton);
        frame.add(topPanel, BorderLayout.NORTH);

        wordPanel = new JPanel(null); // Allow free positioning
        wordPanel.setPreferredSize(new Dimension(600, 300));

        bottomPanel = new JPanel(new BorderLayout());
        resultLabel = new JLabel(">> ");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        bottomPanel.add(resultLabel, BorderLayout.CENTER);

        timerLabel = new JLabel("Time: 0s");
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        bottomPanel.add(timerLabel, BorderLayout.EAST);

        clickedWordsLabel = new JLabel(">> ");
        clickedWordsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        bottomPanel.add(clickedWordsLabel, BorderLayout.WEST);

        frame.add(wordPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
        startNewText(); // Start the first round
    }

    private void startNewText() {
        // Clear previous text
        resultLabel.setText(">> ");
        clickedWordsLabel.setText(">> ");

        if (timer != null) {
            timer.stop();
        }

        // Select a random sentence
        currentSentence = sentences[new Random().nextInt(sentences.length)];
        userSentence = new StringBuilder();
        clickedWordsCount = 0;

        // Split the sentence into words and shuffle them
        String[] words = currentSentence.split(" ");
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(words));
        Collections.shuffle(wordList);

        wordPanel.removeAll(); // Clear previous words
        wordLabels = new ArrayList<>();

        // Create and display the shuffled word labels
        for (int i = 0; i < wordList.size(); i++) {
            JLabel wordLabel = new JLabel(wordList.get(i));
            wordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            wordLabel.setBounds(50 + (i % 5) * 100, 50 + (i / 5) * 50, 80, 30); // Random position
            wordLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            wordLabel.addMouseListener(new WordClickListener(wordLabel));
            wordPanel.add(wordLabel);
            wordLabels.add(wordLabel);
        }

        wordPanel.revalidate();
        wordPanel.repaint();

        // Start the timer
        seconds = 0;
        timerLabel.setText("Time: " + seconds + "s");
        timer = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                timerLabel.setText("Time: " + seconds + "s");
            }
        });
        timer.start();  // 타이머 시작
    }

    private class WordClickListener extends MouseAdapter {
        private JLabel wordLabel;

        public WordClickListener(JLabel wordLabel) {
            this.wordLabel = wordLabel;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // Check if the word has already been clicked
            if (!wordLabel.isEnabled()) {
                return; // Ignore if the word has already been clicked
            }

            String word = wordLabel.getText();
            userSentence.append(word).append(" ");
            clickedWordsCount++;
            clickedWordsLabel.setText(">> " + userSentence.toString().trim());

            // Disable further clicks on this word and change color to light gray
            wordLabel.setEnabled(false); // Disable further interaction
            wordLabel.setForeground(Color.LIGHT_GRAY); // Change the color of clicked word

            // If the user completes the sentence, show success or failure message
            if (clickedWordsCount == wordLabels.size()) {
                timer.stop();
                if (userSentence.toString().trim().equals(currentSentence)) {
                    resultLabel.setText(">> 성공!");
                } else {
                    resultLabel.setText(">> 실패!");
                }
            }
        }
    }
}
