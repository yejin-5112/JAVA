package OpenChallenge5;

import java.util.Random;
import java.util.Scanner;

public class WordScrambleGame {
    public static void main(String[] args) {
        String[] words = {"happy", "morning", "package", "together", "sunny", "beautiful", "bright"};
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("10초 안에 단어를 맞추세요!!");

        while (true) {
            String word = words[random.nextInt(words.length)];
            String scrambledWord = scrambleWord(word);

            System.out.println(scrambledWord);

            System.out.print(">>");
            long startTime = System.currentTimeMillis();
            String userInput = scanner.nextLine();
            long endTime = System.currentTimeMillis();

            long elapsedTime = (endTime - startTime) / 1000;

            if (userInput.equals("그만")) {
                break;
            }

            if (elapsedTime <= 10 && userInput.equals(word)) {
                System.out.println("성공!!! " + elapsedTime + "초 경과");
            } else if (elapsedTime > 10) {
                System.out.println("실패!!! " + word + " 입니다. " + "(시간 초과)");
            } else {
                System.out.println("실패!!! " + word + " 입니다.");
            }
        }
        scanner.close();
    }

    private static String scrambleWord(String word) {
        Random random = new Random();
        StringBuilder scrambled = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            int j = random.nextInt(word.length());
            char temp = scrambled.charAt(i);
            scrambled.setCharAt(i, scrambled.charAt(j));
            scrambled.setCharAt(j, temp);
        }
        return scrambled.toString();
    }
}
