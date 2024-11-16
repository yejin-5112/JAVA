package OpenChallenge6;

import java.io.File;
import java.util.Scanner;

public class FileExplorerMOS {

    public static void printDirectoryContents(File dir) {
        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("디렉토리를 읽을 수 없습니다.");
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.printf("dir\t%9d바이트\t%s\n", file.length(), file.getName());
            } else {
                System.out.printf("file\t%9d바이트\t%s\n", file.length(), file.getName());
            }
        }
    }

    public static void navigateDirectory() {
        Scanner scanner = new Scanner(System.in);
        File currentDir = new File("/");

        while (true) {
            System.out.println("\n***** 파일 탐색기입니다. *****\n");
            System.out.printf("\t[%s]\n", currentDir.getAbsolutePath());

            printDirectoryContents(currentDir);

            System.out.print("\n>> ");
            String command = scanner.nextLine().trim();

            if (command.equals("..")) {
                File parentDir = currentDir.getParentFile();
                if (parentDir != null) {
                    currentDir = parentDir;
                } else {
                    System.out.println("최상위 디렉토리입니다.");
                }
            } else if (command.equals("")) {
                continue;
            } else {
                File newDir = new File(currentDir, command);
                if (newDir.isDirectory()) {
                    currentDir = newDir;
                } else {
                    System.out.printf("'%s'은 유효한 디렉토리가 아닙니다.\n", command);
                }
            }
        }
    }

    public static void main(String[] args) {
        navigateDirectory();
    }
}
