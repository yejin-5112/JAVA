package OpenChallenge1;

import java.util.Scanner;

public class Bunsik {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("**** 자바 분식입니다. 주문하면 금액을 알려드립니다. ****");
		System.out.print("떡볶이 몇 인분>>");
		int tteokbokki = scanner.nextInt();
		System.out.print("김말이 몇 인분>>");
		int kimmali = scanner.nextInt();
		System.out.print("쫄면 몇 인분>>");
		int jjolmyeon = scanner.nextInt();
		
		int sum = (tteokbokki * 2000) + (kimmali * 1000) + (jjolmyeon * 3000);
		System.out.println("전체 금액은 " + sum + "원입니다.");
		
		scanner.close();
	}

}
