package OpenChallenge2;

import java.util.Random;

public class RandomIntegers {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random()*9) + 11; 
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

        System.out.printf("평균 %.1f\n", average);
    }
}