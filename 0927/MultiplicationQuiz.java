package OpenChallenge2;

import java.util.Random;
import java.util.Scanner;

public class MultiplicationQuiz {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int wrongAttempts = 0;
        
        System.out.println("***** 구구단을 맞추는 퀴즈입니다. *****");

        while (wrongAttempts < 3) {
            int num1 = (int)(Math.random()*9 + 1);
            int num2 = (int)(Math.random()*9 + 1);
            int correctAnswer = num1 * num2;

            System.out.printf("%d x %d = ? ", num1, num2);
            int userAnswer = scanner.nextInt();

            if (userAnswer == correctAnswer) {
                System.out.println("정답입니다. 잘했습니다.");
            } else {
                wrongAttempts++;
                if (wrongAttempts < 3) {
                    System.out.println(wrongAttempts + "번 틀렸습니다. 분발하세요.");
                }
            }
        }

        System.out.println("3번 틀렸습니다. 퀴즈 종료합니다.");
        scanner.close();
    }
}