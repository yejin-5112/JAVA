package OpenChallenge3;

import java.util.Scanner;

public class Diary {
    private String[] entries;

    public Diary() {
        entries = new String[30]; // 30일의 다이어리
    }

    public void recordEntry(int date, String text) {
        if (date < 1 || date > 30) {
            System.out.println("날짜는 1부터 30까지 입력해야 합니다.");
            return;
        }
        entries[date - 1] = text; // 날짜에 맞춰 텍스트 저장
    }

    public void displayEntries() {
        for (int i = 0; i < entries.length; i++) {
            if ((i % 7 == 0) && i != 0) { // 7일마다 줄 바꿈
                System.out.println();
            }
            if (entries[i] != null) {
                System.out.print(entries[i] + "\t\t"); // 텍스트를 출력
            } else {
                System.out.print("…\t\t"); // ... 출력
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Diary diary = new Diary();
        System.out.println("***** 2024년 10월 다이어리 *****");

        while (true) {
            System.out.print("기록:1, 보기:2, 종료:3>> ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("날짜(1~30)와 텍스트(빈칸없이 4글자이하)>> ");
                String input = scanner.nextLine();
                String[] parts = input.split(" ");
                if (parts.length != 2) {
                    System.out.println("잘못된 입력입니다. 날짜와 텍스트를 공백으로 구분하여 입력하세요.");
                    continue;
                }
                try {
                    int date = Integer.parseInt(parts[0]);
                    String text = parts[1];
                    if (text.length() > 4) {
                        System.out.println("기억할 일은 빈칸 없이 4글자 이하이어야 합니다.");
                    } else {
                        diary.recordEntry(date, text);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("날짜는 숫자여야 합니다.");
                }
            } else if (choice == 2) {
                diary.displayEntries();
            } else if (choice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
        scanner.close();
    }
}