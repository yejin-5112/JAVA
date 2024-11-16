package OpenChallenge6;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("문자열들을 입력하세요>> ");
            String input = scanner.nextLine();

            if (input.equals("그만")) {
                break;
            }

            String[] words = input.split(" ");
            LinkedHashSet<String> uniqueWordsSet = new LinkedHashSet<>();
            
            for (String word : words) {
                uniqueWordsSet.add(word);
            }
            
            ArrayList<String> uniqueWordsList = new ArrayList<>(uniqueWordsSet);
            for (String word : uniqueWordsList) {
                System.out.print(word + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

