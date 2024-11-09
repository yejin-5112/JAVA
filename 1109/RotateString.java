package OpenChallenge5;

import java.util.Scanner;

public class RotateString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("문자열을 입력하세요. 빈 칸이 있어도 되고 영어 한글 모두 됩니다");
        String input = scanner.nextLine();

        int length = input.length();

        for (int i = 0; i < length+1; i++) {
            String rotated = rotate(input, i);
            System.out.println(rotated);
        }

        scanner.close();
    }

    public static String rotate(String str, int n) {
        int length = str.length();
        return str.substring(n % length) + str.substring(0, n % length);
    }
}
