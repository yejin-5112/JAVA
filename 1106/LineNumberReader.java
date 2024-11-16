package OpenChallenge6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineNumberReader {

    public static void main(String[] args) {
        // String filePath = "c:\\windows\\system.ini"; //윈도우
        String filePath = "/Users/jin-i/test/system.ini"; //맥

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println(filePath + " 파일을 읽어 출력합니다.");
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                System.out.printf("%4d: %s%n", lineNumber, line);
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("파일을 읽는 중 오류가 발생했습니다.");
        }
    }
}
