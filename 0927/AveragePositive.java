package OpenChallenge2;

import java.util.Scanner;

public class AveragePositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("양의 정수를 입력하세요. -1은 입력 끝>> ");
        
        int sum = 0;
        int count = 0;
        StringBuilder excludedNumbers = new StringBuilder();

        while (true) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            
            boolean endInput = false; // -1 입력 여부 체크

            for (String part : parts) {
                if (part.equals("-1")) {
                    endInput = true; // -1이 입력된 경우
                    break;
                }
                try {
                    int number = Integer.parseInt(part);
                    if (number > 0) {
                        sum += number;
                        count++;
                    } else {
                        excludedNumbers.append(part).append(" 제외\n");
                    }
                } catch (NumberFormatException e) {
                    excludedNumbers.append(part).append(" 제외\n");
                }
            }

            if (endInput) {
                break;
            }
        }

        if (excludedNumbers.length() > 0) {
        	System.out.print(excludedNumbers.toString().trim() + "\n");
        }

        if (count > 0) {
            double average = (double) sum / count;
            System.out.printf("평균은 %.2f\n", average);
        } else {
            System.out.println("양수 입력이 없습니다.");
        }

        scanner.close();
    }
}