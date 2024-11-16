package OpenChallenge6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyWithProgress {

    public static void main(String[] args) {
        String sourceFile = "a.jpg";
        String destinationFile = "b.jpg";


        try (FileInputStream inputStream = new FileInputStream(sourceFile);
             FileOutputStream outputStream = new FileOutputStream(destinationFile)) {
             
            System.out.println(sourceFile + "를 " + destinationFile + "로 복사합니다.");
            System.out.println("10%마다 *를 출력합니다.");

            long totalBytes = inputStream.available();
            long bytesCopied = 0;
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                bytesCopied += bytesRead;

                if (bytesCopied * 10 / totalBytes > (bytesCopied - bytesRead) * 10 / totalBytes) {
                    System.out.print("*");
                }
            }
            System.out.println();
            System.out.println("파일 복사가 완료되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 복사 중 오류가 발생했습니다.");
        }
    }
}
