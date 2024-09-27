package OpenChallenge2;

import java.util.Random;
import java.util.Scanner;

public class GamblingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean continueGame = true;

        while (continueGame) {
            System.out.print("엔터키 입력>> ");
            scanner.nextLine();

            int[] numbers = new int[3];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = random.nextInt(3);
            }

            System.out.printf("%d %d %d\n", numbers[0], numbers[1], numbers[2]);

            if (numbers[0] == numbers[1] && numbers[1] == numbers[2]) {
                System.out.println("성공, 대박났어요!");
                System.out.print("계속하시겠습니까?(yes/no)>> ");
                String response = scanner.nextLine();
                continueGame = response.equalsIgnoreCase("yes");
            }
        }

        System.out.println("게임을 종료합니다.");
        scanner.close();
    }
}