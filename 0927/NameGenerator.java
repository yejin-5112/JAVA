package OpenChallenge2;

import java.util.Scanner;

public class NameGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       System.out.println("***** 작명 프로그램이 실행됩니다. *****");
        
        String boyMiddle [] = {"민", "지", "준", "현", "영"};
        String boyEnd [] = {"수", "호", "철", "빈", "욱"};
        
        String girlMiddle [] = {"지", "수", "민", "서", "유", "예", "은"};
        String girlEnd [] = {"아", "진", "현", "경", "희"};

        while (true) {
            System.out.print("남/여 선택>> ");
            String gender = scanner.nextLine();

            if (gender.equals("그만")) {
                break;
            }

            System.out.print("성 입력>> ");
            String lastName = scanner.nextLine();

            String firstName = "";
            if (gender.equals("남")) {
                String middle = boyMiddle[(int) (Math.random() * boyMiddle.length)];
                String end = boyEnd[(int) (Math.random() * boyEnd.length)];
                firstName = middle + end;
            } else if (gender.equals("여")) {
                String middle = girlMiddle[(int) (Math.random() * girlMiddle.length)];
                String end = girlEnd[(int) (Math.random() * girlEnd.length)];
                firstName = middle + end;
            } else {
                System.out.println("남/여/그만 중에서 입력하세요!");
                continue;
            }

            System.out.printf("추천 이름: %s%s\n", lastName, firstName);
        }

        System.out.println("프로그램이 종료되었습니다.");
        scanner.close();
    }
}