package OpenChallenge5;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("여러 과목의 학점을 빈 칸으로 분리 입력>> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("그만")) {
                break;
            }

            String[] grades = input.split("\\s+");
            int totalScore = 0;
            int count = 0;
            boolean isValid = true;

            for (String grade : grades) {
                int score = convertGradeToScore(grade);
                if (score == -1) {
                    System.out.println("입력 오류: " + grade);
                    isValid = false;
                    break;
                }
                totalScore += score;
                count++;
            }

            if (isValid && count > 0) {
                double average = (double) totalScore / count;
                System.out.println("평균은 " + average);
            }
        }

        scanner.close();
    }

    public static int convertGradeToScore(String grade) {
        switch (grade.toLowerCase()) {
            case "a":
                return 100;
            case "b":
                return 90;
            case "c":
                return 80;
            case "d":
                return 70;
            case "f":
                return 0;
            default:
                return -1;
        }
    }
}
