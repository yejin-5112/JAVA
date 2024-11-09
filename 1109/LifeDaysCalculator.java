package OpenChallenge5;

import java.util.Calendar;
import java.util.Scanner;

public class LifeDaysCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Calendar today = Calendar.getInstance();
        System.out.println("오늘은 " + today.get(Calendar.YEAR) + "년 " 
                           + (today.get(Calendar.MONTH) + 1) + "월 " 
                           + today.get(Calendar.DAY_OF_MONTH) + "일");

        while (true) {
            System.out.print("생일 입력(년 월 일)>> ");
            String input = scanner.nextLine();

            if (input.equals("그만")) {
                break;
            }

            String[] dateParts = input.split(" ");
            if (dateParts.length != 3) {
                System.out.println("입력 오류: 생일을 제대로 입력해 주세요.");
                continue;
            }

            try {
                int year = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]) - 1;
                int day = Integer.parseInt(dateParts[2]);

                Calendar birthDate = Calendar.getInstance();
                birthDate.set(year, month, day);

                long diffInMillis = today.getTimeInMillis() - birthDate.getTimeInMillis();
                long daysLived = diffInMillis / (24 * 60 * 60 * 1000);

                System.out.println("오늘까지 " + (daysLived + 1) + "일 살아왔습니다.");

            } catch (NumberFormatException e) {
                System.out.println("입력 오류: 숫자 형식이 올바르지 않습니다.");
            }
        }

        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }
}
