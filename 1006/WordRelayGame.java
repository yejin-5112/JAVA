package OpenChallenge3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordRelayGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 게임 시작 문구 출력
        System.out.println("끝말잇기 게임을 시작합니다...");

        // 참가 인원 수 입력
        System.out.print("게임에 참가하는 인원 몇명입니까>>");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();  // 개행 문자 처리

        // 참가자 이름 입력
        List<String> players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("참가자의 이름을 입력하세요>>");
            String playerName = scanner.nextLine();
            players.add(playerName);
        }

        // 게임 시작
        System.out.println("시작하는 단어는 '아버지'입니다.");
        String currentWord = "아버지";

        int currentPlayerIndex = 0;
        while (true) {
            // 현재 참가자 이름 출력
            String currentPlayer = players.get(currentPlayerIndex);
            System.out.print(currentPlayer + ">> ");

            // 단어 입력 받기
            String nextWord = scanner.nextLine();

            // 끝말잇기 조건 검사
            char lastChar = currentWord.charAt(currentWord.length() - 1);
            char firstChar = nextWord.charAt(0);

            if (lastChar != firstChar) {
                // 끝말잇기 실패
                System.out.println(currentPlayer + "이 졌습니다.");
                break;
            }

            // 다음 단어로 갱신
            currentWord = nextWord;

            // 다음 참가자로 넘어가기
            currentPlayerIndex = (currentPlayerIndex + 1) % numPlayers;
        }

        scanner.close();
    }
}