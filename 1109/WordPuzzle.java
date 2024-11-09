package OpenChallenge5;

import java.util.Random;
import java.util.Scanner;

public class WordPuzzle {
    private static final int SIZE = 5;
    private static final char[][] grid = new char[SIZE][SIZE];
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("단어를 입력하세요 (빈칸으로 구분, '그만'을 입력하면 종료): ");
            String input = scanner.nextLine();

            if (input.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String[] words = input.split(" ");

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    grid[i][j] = ' ';
                }
            }

            for (String word : words) {
                placeWord(word);
            }

            fillRandomLetters();

            printGrid();
        }

        scanner.close();
    }

    private static void placeWord(String word) {
        int wordLength = word.length();
        boolean placed = false;

        int[][] directions = {
            {0, 1},
            {1, 0},
            {1, 1},
            {-1, 1}
        };

        while (!placed) {
            int x = random.nextInt(SIZE);
            int y = random.nextInt(SIZE);
            shuffleArray(directions);

            for (int[] direction : directions) {
                int dx = direction[0];
                int dy = direction[1];
                if (canPlace(word, x, y, dx, dy)) {
                    for (int i = 0; i < wordLength; i++) {
                        grid[x + i * dx][y + i * dy] = word.charAt(i);
                    }
                    placed = true;
                    break;
                }
            }
        }
    }

    private static boolean canPlace(String word, int x, int y, int dx, int dy) {
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            int nx = x + i * dx;
            int ny = y + i * dy;
            if (nx < 0 || nx >= SIZE || ny < 0 || ny >= SIZE || grid[nx][ny] != ' ') {
                return false;
            }
        }
        return true;
    }

    private static void fillRandomLetters() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == ' ') {
                    grid[i][j] = (char) ('a' + random.nextInt(26));
                }
            }
        }
    }

    private static void printGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void shuffleArray(int[][] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int[] temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
