package OpenChallenge1;

import java.util.Scanner;

public class travel {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("여행지>>");
		String  td = scanner.nextLine();
		System.out.print("인원수>>");
		int people = scanner.nextInt();
		System.out.print("숙박일>>");
		int day = scanner.nextInt();
		System.out.print("1인당 항공료>>");
		int airfare = scanner.nextInt();
		System.out.print("1방 숙박비>>");
		int roomRate = scanner.nextInt();
		
		int rooms = (int) Math.ceil(people / 2.0);
		int sum = (roomRate*rooms*day) + (airfare*people);
		
		System.out.println(people + "명의 " + td + " " + day + "박 " + (day+1) + "일 여행에는 방이 " + rooms + "개 필요하며 경비는 " + sum + "원입니다.");
		
		scanner.close();
	}

}
