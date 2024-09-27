package OpenChallenge2;

import java.util.Scanner;

public class GradeLookup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String course[] = {"C", "C++", "Python", "Java", "HTML5"};
        String grade[] = {"A", "B+", "B", "A+", "D"};

        while (true) {
            System.out.print("과목>> ");
            String courseInput = scanner.nextLine();

            if (courseInput.equals("그만")) {
                break;
            }

            boolean found = false;
            for (int i = 0; i < course.length; i++) {
                if (course[i].equals(courseInput)) {
                    System.out.printf("%s 학점은 %s\n", courseInput, grade[i]);
                    found = true;
                    break;
                }
            }

            if (!found) {
            	System.out.printf("%s는 없는 과목입니다.\n", courseInput);
            }
        }

        System.out.println("프로그램이 종료되었습니다.");
        scanner.close();
    }
}