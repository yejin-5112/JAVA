package OpenChallenge2;

import java.util.Random;

public class Random2D {
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        Random random = new Random();
        
        System.out.println("4X4 배열에 랜덤한 값을 저장한 후 출력합니다.");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = random.nextInt(256);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}