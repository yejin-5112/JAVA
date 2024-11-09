package OpenChallenge5;

import java.util.Random;
import java.util.Scanner;

class Player {
    private String name;
    private int[] numbers = new int[3];
    private Random random = new Random();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void generateRandomNumbers() {
        for (int i = 0; i < 3; i++) {
            numbers[i] = random.nextInt(3) + 1;
        }
    }

    public void printNumbers() {
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }

    public boolean checkWin() {
        return numbers[0] == numbers[1] && numbers[1] == numbers[2];
    }
}

public class GamblingGameTogeter {
    private Player[] players;
    private int numPlayers;
    private Random random = new Random();

    public GamblingGameTogeter(int numPlayers) {
        this.numPlayers = numPlayers;
        players = new Player[numPlayers];
    }

    public void addPlayers() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numPlayers; i++) {
            System.out.printf("%d번째 선수 이름>>", i + 1);
            String name = scanner.nextLine();
            players[i] = new Player(name);
        }
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        System.out.println("게임을 시작합니다!\n");

        while (!gameWon) {
            for (Player player : players) {
                System.out.printf("[%s]:<Enter>", player.getName());
                scanner.nextLine();
                System.out.print("   ");
                player.generateRandomNumbers();
                player.printNumbers();

                if (player.checkWin()) {
                    System.out.printf("%s님이 이겼습니다!\n", player.getName());
                    gameWon = true;
                    break;
                } else {
                    System.out.println(" 아쉽군요!");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("겜블링 게임에 참여할 선수 숫자>>");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();
        GamblingGameTogeter game = new GamblingGameTogeter(numPlayers);
        game.addPlayers();
        game.startGame();
    }
}

