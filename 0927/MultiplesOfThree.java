package OpenChallenge2;

import java.util.Scanner;

public class MultiplesOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];

        System.out.print("양의 정수 10개 입력>> :");
        String input = scanner.nextLine();
        String[] inputNumbers = input.split(" ");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        System.out.print("3의 배수는...");
        for (int num : numbers) {
            if (num % 3 == 0) {
                System.out.print(num + " ");
            }
        }

        scanner.close();
    }
}