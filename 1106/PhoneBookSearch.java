package OpenChallenge6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBookSearch {

    public static void main(String[] args) {
        //String filePath = "c:\\temp\\phone.txt"; //윈도우
        String filePath = "/Users/jin-i/temp/phone.txt"; //맥
        
        
        Map<String, String> phoneBook = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int totalEntries = 0;
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    phoneBook.put(parts[0], parts[1]);
                    totalEntries++;
                }
            }
            System.out.println("총 " + totalEntries + "개의 전화번호를 읽었습니다.");
        } catch (IOException e) {
            System.out.println("파일을 읽는 중 오류가 발생했습니다.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("이름>> ");
            String name = scanner.nextLine().trim();

            if ("그만".equalsIgnoreCase(name)) {
                break; 
            }

            if (phoneBook.containsKey(name)) {
                System.out.println(phoneBook.get(name));
            } else {
                System.out.println("찾는 이름이 없습니다.");
            }
        }

        scanner.close();
    }
}
