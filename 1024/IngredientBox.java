package OpenChallenge4;

import java.util.Scanner;

class IngredientBox extends Box {
    private String name;

    public IngredientBox(String name, int size) {
        super(size);
        this.name = name;
    }

    @Override
    public boolean consume() {
        if (size > 0) {
            size--;
            return true;
        }
        return false;
    }

    @Override
    public void print() {
        System.out.print(name + " ");
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.print(" " + size);
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IngredientBox coffeeBox = new IngredientBox("커피", 5);
        IngredientBox creamBox = new IngredientBox("프림", 5);
        IngredientBox sugarBox = new IngredientBox("설탕", 5);

        System.out.println("*****청춘 커피 자판기 입니다.*****");
        coffeeBox.print();
        creamBox.print();
        sugarBox.print();

        while (true) {
            System.out.println("다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>> ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("청춘 커피 자판기 프로그램을 종료합니다.");
                break;
            }

            boolean coffeeConsumed = false;
            if (choice == 1) { // 다방커피
                coffeeConsumed = coffeeBox.consume() && creamBox.consume() && sugarBox.consume(); // 모든 재료 소비
            } else if (choice == 2) { // 설탕 커피
                coffeeConsumed = coffeeBox.consume() && sugarBox.consume();
            } else if (choice == 3) { // 블랙 커피
                coffeeConsumed = coffeeBox.consume();
            }

            if (coffeeConsumed) {
                coffeeBox.print();
                creamBox.print();
                sugarBox.print();
            } else {
                System.out.println("원료가 부족합니다.");
                coffeeBox.print();
                creamBox.print();
                sugarBox.print();
            }
        }
        scanner.close();
    }
}