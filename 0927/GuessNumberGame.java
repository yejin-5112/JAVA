package OpenChallenge2;

import java.util.Scanner;
import java.util.Random;

public class GuessNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(100); // 0에서 99 사이의 임의의 수 생성
            int userGuess = -1;
            int attemptCount = 1;

            System.out.println("수를 결정하였습니다. 맞추어 보세요.");

            while (userGuess != targetNumber) {
                System.out.print(attemptCount + ">>");
                userGuess = scanner.nextInt();

                if (userGuess < targetNumber) {
                    System.out.println("더 높게");
                } else if (userGuess > targetNumber) {
                    System.out.println("더 낮게");
                } else {
                    System.out.println("맞았습니다.");
                }

                attemptCount++;
            }

            System.out.print("다시하시겠습니까(y/n): ");
            char response = scanner.next().charAt(0);
            if (response == 'n' || response == 'N') {
                playAgain = false;
            }
        }

        System.out.println("게임을 종료합니다. 감사합니다!");
        scanner.close();
    }
}