package OpenChallenge1;

import java.util.Scanner;

public class birthday {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("생일 입력 하세요>>");
        String birth = scanner.next();
        
        String year = birth.substring(0, 4);
        String month = birth.substring(4, 6);
        String day = birth.substring(6, 8);
        
        System.out.println(year + "년 " + Integer.parseInt(month) + "월 " + Integer.parseInt(day) + "일");
        
        scanner.close();
	}

}
