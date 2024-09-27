package OpenChallenge2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentScoreManager {
    public static void main(String[] args) {
        int[] studentIds = new int[10];
        int[] scores = new int[10];
        Scanner scanner = new Scanner(System.in);

        // 10명의 학생의 학번과 점수 입력받기
        for (int i = 0; i < 10; i++) {
            while (true) {
                System.out.printf("%d>> 학번 점수: ", i + 1);
                String input = scanner.nextLine(); // 한 줄로 입력받기
                String[] parts = input.split(" "); // 공백으로 구분

                if (parts.length != 2) {
                    System.out.println("경고!! 올바른 형식으로 입력하세요. 예: 12345 90");
                    continue; // 올바른 형식이 아닐 경우 다시 입력받기
                }

                try {
                    studentIds[i] = Integer.parseInt(parts[0]); // 학번
                    scores[i] = Integer.parseInt(parts[1]); // 점수
                    break; // 유효한 입력이 들어오면 루프 종료
                } catch (NumberFormatException e) {
                    System.out.println("경고!! 정수를 입력하세요.");
                }
            }
        }

        while (true) {
            System.out.print("학번으로 검색: 1, 점수로 검색: 2, 끝내려면 3>> ");
            int choice;
            while (true) {
                try {
                    choice = scanner.nextInt();
                    break; // 유효한 입력이 들어오면 루프 종료
                } catch (InputMismatchException e) {
                    System.out.println("경고!! 정수를 입력하세요.");
                    scanner.next(); // 잘못된 입력을 소비하고 다시 입력받기
                }
            }

            if (choice == 3) {
                break;
            }

            if (choice == 1) {
                int searchId;
                while (true) {
                    System.out.print("학번>> ");
                    try {
                        searchId = scanner.nextInt();
                        break; // 유효한 입력이 들어오면 루프 종료
                    } catch (InputMismatchException e) {
                        System.out.println("경고!! 정수를 입력하세요.");
                        scanner.next(); // 잘못된 입력을 소비하고 다시 입력받기
                    }
                }

                boolean found = false;
                for (int i = 0; i < studentIds.length; i++) {
                    if (studentIds[i] == searchId) {
                        System.out.printf("학생 %d의 점수는 %d입니다.\n", studentIds[i], scores[i]);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.printf("%d의 학생은 없습니다.\n", searchId);
                }
            } else if (choice == 2) {
                int searchScore;
                while (true) {
                    System.out.print("점수>> ");
                    try {
                        searchScore = scanner.nextInt();
                        break; // 유효한 입력이 들어오면 루프 종료
                    } catch (InputMismatchException e) {
                        System.out.println("경고!! 정수를 입력하세요.");
                        scanner.next(); // 잘못된 입력을 소비하고 다시 입력받기
                    }
                }

                StringBuilder foundIds = new StringBuilder();
                for (int i = 0; i < scores.length; i++) {
                    if (scores[i] == searchScore) {
                        if (foundIds.length() > 0) {
                            foundIds.append(", "); // 여러 학번을 구분하기 위해 쉼표 추가
                        }
                        foundIds.append(studentIds[i]); // 학번 추가
                    }
                }
                if (foundIds.length() > 0) {
                    System.out.printf("점수가 %d인 학생은 %s입니다.\n", searchScore, foundIds.toString());
                } else {
                    System.out.printf("점수가 %d인 학생은 없습니다.\n", searchScore);
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }

        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }
}