package OpenChallenge6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //File file = new File("c:\\temp\\phone.txt"); //윈도우
        File file = new File("/Users/jin-i/temp/phone.txt"); //맥

        file.getParentFile().mkdirs();

        try (FileWriter writer = new FileWriter(file, true)) {
            System.out.println("전화번호 입력 프로그램입니다.");
            
            while (true) {
                System.out.print("이름 전화번호>> ");
                String input = scanner.nextLine();
                
                if (input.equals("그만")) {
                    break;
                }
                
                writer.write(input + System.lineSeparator());
            }

            //System.out.println("c:\\temp\\phone.txt에 저장하였습니다."); //윈도우
            System.out.println("/Users/jin-i/temp/phone.txt에 저장하였습니다."); //맥

        } catch (IOException e) {
            System.out.println("파일을 저장하는 중 오류가 발생했습니다.");
        } finally {
            scanner.close();
        }
    }
}
