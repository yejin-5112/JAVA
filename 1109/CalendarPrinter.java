package OpenChallenge5;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("년도 입력(-1이면 종료)>> ");
            int year = scanner.nextInt();
            
            if (year == -1) {
                break;
            }
            
            // 1월부터 12월까지 출력
            for (int month = 0; month < 12; month++) {
                printMonth(year, month);
                System.out.println();
            }
        }
        
        scanner.close();
    }

    public static void printMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1);
        
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);  // 해당 월의 일 수
        int startDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);  // 해당 월의 1일이 무슨 요일인지 (일요일 = 1)
        
        // 월 정보 출력
        System.out.println(year + "년 " + (month + 1) + "월");
        
        // 요일 출력 (일 월 화 수 목 금 토)
        System.out.println("일 월 화 수 목 금 토");
        
        // 1일이 시작하는 요일까지 공백을 출력
        for (int i = 1; i < startDayOfWeek; i++) {
            System.out.print("   ");
        }

        // 각 날짜 출력
        for (int day = 1; day <= daysInMonth; day++) {
            // 날짜를 두 자릿수로 맞춰서 출력
            System.out.printf("%2d ", day);
            
            // 한 주(일~토)가 끝날 때마다 줄바꿈
            if ((startDayOfWeek + day - 1) % 7 == 0) {
                System.out.println();
            }
        }
        
        // 마지막 줄을 빈 줄로 처리하여 출력 형식을 맞추기 위해
        System.out.println();
    }
}
