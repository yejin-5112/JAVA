package OpenChallenge2;

import java.util.Scanner;

public class MultiplyTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("곱하고자 하는 정수 2개 입력>> ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("그만")) {
                break;
            }

            String[] parts = input.split(" ");

            if (parts.length != 2) {
                System.out.println("정수를 입력하세요!");
                continue;
            }

            try {
                int n = Integer.parseInt(parts[0]);
                int m = Integer.parseInt(parts[1]);
                System.out.println(n + " X " + m + " = " + (n * m));
            } catch (NumberFormatException e) {
                System.out.println("정수를 입력하세요!");
            }
        }

        System.out.println("프로그램이 종료되었습니다.");
        scanner.close();
    }
}
