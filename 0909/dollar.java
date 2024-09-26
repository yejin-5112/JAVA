package OpenChallenge1;

import java.util.Scanner;

public class dollar {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("$1 = 1200원입니다. 달러를 입력하세요>>");
		int number = scanner.nextInt();
		System.out.println("$" + number + "는 " + number*1200 + "원입니다.");
		
		scanner.close();
		
	}

}
