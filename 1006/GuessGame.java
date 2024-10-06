package OpenChallenge3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        score += points;
    }
}

public class GuessGame {
    private List<Player> players;

    public GuessGame() {
        players = new ArrayList<>();
    }

    public void startGame() {
        System.out.println("*** 예측 게임을 시작합니다. ***");
        Scanner scanner = new Scanner(System.in);

        System.out.print("게임에 참여할 선수 수>> ");
        int playerCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < playerCount; i++) {
            System.out.print("선수 이름>> ");
            String playerName = scanner.nextLine();
            players.add(new Player(playerName));
        }

        boolean continueGame = true;

        while (continueGame) {
            int hiddenNumber = new Random().nextInt(100) + 1;
            System.out.println("1~100사이의 숫자가 결정되었습니다. 선수들은 맞추어 보세요.");

            int closestDifference = Integer.MAX_VALUE;
            Player winner = null;

            for (Player player : players) {
                System.out.print(player.getName() + ">> ");
                int guess = scanner.nextInt();
                int difference = Math.abs(hiddenNumber - guess);

                if (difference < closestDifference) {
                    closestDifference = difference;
                    winner = player;
                }
            }

            System.out.println("정답은 " + hiddenNumber + ". " +winner.getName() + "이 이겼습니다. 승점 1점 확보!");
            winner.addScore(1);

            System.out.print("계속하려면 yes 입력>> ");
            scanner.nextLine(); // Consume newline
            String continueInput = scanner.nextLine();

            if (!continueInput.equalsIgnoreCase("yes")) {
                continueGame = false;
            }
        }

        for (Player player : players) {
            System.out.print(player.getName() + ":" + player.getScore() + " ");
        }
        System.out.println();

        Player finalWinner = players.get(0);
        for (Player player : players) {
            if (player.getScore() > finalWinner.getScore()) {
                finalWinner = player;
            }
        }

        System.out.println(finalWinner.getName() + "이 최종 승리하였습니다.");
        scanner.close();
    }

    public static void main(String[] args) {
        GuessGame game = new GuessGame();
        game.startGame();
    }
}