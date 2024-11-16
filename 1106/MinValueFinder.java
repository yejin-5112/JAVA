package OpenChallenge6;

import java.util.Scanner;
import java.util.Vector;

public class MinValueFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> numbers = new Vector<>();
        
        System.out.println("정수 입력(-1이면 입력 끝)>>");
        
        while (true) {
            int input = scanner.nextInt();
            
            if (input == -1) {
                break;
            }
            
            if (input > 0) {
                numbers.add(input);
            } else {
                System.out.println("양의 정수만 입력해주세요.");
            }
        }
        
        if (numbers.size() > 0) {
            int minValue = numbers.get(0);
            for (int number : numbers) {
                if (number < minValue) {
                    minValue = number;
                }
            }
            System.out.println("제일 작은 수는 " + minValue);
        } else {
            System.out.println("입력된 양의 정수가 없습니다.");
        }
        
        scanner.close();
    }
}
