package OpenChallenge2;

import java.util.Random;
import java.util.Scanner;
import java.util.HashSet;

public class UniqueRandomIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("정수 몇 개 저장하시겠습니까>> ");
        int count = scanner.nextInt();

        HashSet<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < count) {
            int randomNumber = random.nextInt(100) + 1;
            uniqueNumbers.add(randomNumber);
        }

        int[] numbers = new int[count];
        int index = 0;
        for (int num : uniqueNumbers) {
            numbers[index++] = num;
        }

        System.out.print("랜덤한 정수들...");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = sum / numbers.length;

        System.out.printf("평균은 %.4f\n", average);

        scanner.close();
    }
}