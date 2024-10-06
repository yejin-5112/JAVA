package OpenChallenge3;

import java.util.Scanner;

public class Grade {

    private String name;
    private int javaScore;
    private int webScore;
    private int osScore;

    public Grade(String name, int javaScore, int webScore, int osScore) {
        this.name = name;
        this.javaScore = javaScore;
        this.webScore = webScore;
        this.osScore = osScore;
    }

    public String getName() {
        return name;
    }

    public int getAverage() {
        return (javaScore + webScore + osScore) / 3; // 평균을 정수로 반환
    }
    
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름, 자바, 웹프로그래밍, 운영체제 순으로 점수 입력>>");
		String name = scanner.next();
		int java = scanner.nextInt();
		int web = scanner.nextInt();
		int os = scanner.nextInt();
		Grade st = new Grade(name, java, web, os);
		System.out.printf("%s의 평균은 %d\n", st.getName(), st.getAverage());
		scanner.close();
		
	}
}
