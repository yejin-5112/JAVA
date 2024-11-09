package OpenChallenge5;

import java.util.*;


class Player2 {
    String name;
    int favoriteNumber;
    int matchedCount;

    public Player2(String name, int favoriteNumber) {
        this.name = name;
        this.favoriteNumber = favoriteNumber;
        this.matchedCount = 0;
    }

    public void countMatched(int[] randomNumbers) {
        this.matchedCount = 0;
        for (int num : randomNumbers) {
            if (num == this.favoriteNumber) {
                this.matchedCount++;
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public int getMatchedCount() {
        return this.matchedCount;
    }
}

class NumberExpectationGame {
    private List<Player2> players;

    public NumberExpectationGame(List<Player2> players) {
        this.players = players;
    }

    private int[] generateRandomNumbers() {
        Random rand = new Random();
        int[] randomNumbers = new int[15];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = rand.nextInt(10) + 1;
        }
        return randomNumbers;
    }

    public void playGame() {
        List<Player2> currentPlayers = new ArrayList<>(players);

        while (currentPlayers.size() > 1) {
            System.out.print("\nEnter키 입력>>");

            Scanner sc = new Scanner(System.in);
            sc.nextLine();

            int[] randomNumbers = generateRandomNumbers();

            for (int i = 0; i < randomNumbers.length; i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(randomNumbers[i]);
            }
            System.out.println();

            for (Player2 player : currentPlayers) {
                player.countMatched(randomNumbers);
                System.out.println("[" + player.getName() + "] 맞춘 개수: " + player.getMatchedCount());
            }

            int minMatchedCount = Integer.MAX_VALUE;
            for (Player2 player : currentPlayers) {
                minMatchedCount = Math.min(minMatchedCount, player.getMatchedCount());
            }

            List<Player2> losers = new ArrayList<>();
            for (Player2 player : currentPlayers) {
                if (player.getMatchedCount() == minMatchedCount) {
                    losers.add(player);
                }
            }

            System.out.print("현재 패자들: ");
            for (Player2 loser : losers) {
                System.out.print(loser.getName() + " ");
            }
            System.out.println();

            currentPlayers = new ArrayList<>(losers);
        }

        System.out.println("\n최종 패자는 " + currentPlayers.get(0).getName() + "입니다.");
    }
}

public class LunchGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("게임에 참여할 선수들 이름>>");
        String inputNames = sc.nextLine();
        String[] names = inputNames.split(" ");

        List<Player2> players = new ArrayList<>();

        for (String name : names) {
            System.out.print("[" + name + "] 정수 선택(1~10)>>");
            int favoriteNumber = sc.nextInt();
            players.add(new Player2(name, favoriteNumber));

            sc.nextLine();
        }

        NumberExpectationGame game = new NumberExpectationGame(players);
        game.playGame();

        sc.close();
    }
}
