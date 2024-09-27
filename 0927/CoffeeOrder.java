package OpenChallenge2;

import java.util.Scanner;

public class CoffeeOrder {
    public static void main(String[] args) {
        String[] coffee = {"핫아메리카노", "아이스아메리카노", "카푸치노", "라떼"};
        int[] price = {3000, 3500, 4000, 5000};

        System.out.println("핫아메리카노, 아이스아메리카노, 카푸치노, 라떼 있습니다.");

        Scanner scanner = new Scanner(System.in);
        int totalPrice = 0;
        String lastOrderedItem = "";

        while (true) {
            System.out.print("주문>> ");
            String input = scanner.nextLine();

            if (input.equals("그만")) {
                break;
            }

            String[] orderParts = input.split(" ");
            if (orderParts.length != 2) {
                System.out.println(input + "는 잘못된 입력 형식입니다. 예: 핫아메리카노 2");
                continue;
            }

            String coffeeName = orderParts[0];
            int quantity;

            try {
                quantity = Integer.parseInt(orderParts[1]);
                if (quantity <= 0) {
                    System.out.println("잔 수는 양의 정수로 입력해주세요!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println(coffeeName + "는 없는 메뉴입니다.");
                continue;
            }

            boolean isMenuValid = false;
            for (String item : coffee) {
                if (item.equals(coffeeName)) {
                    isMenuValid = true;
                    break;
                }
            }

            if (!isMenuValid) {
                System.out.println(coffeeName + "는 없는 메뉴입니다.");
            } else {
                int coffeePrice = 0;
                for (int i = 0; i < coffee.length; i++) {
                    if (coffee[i].equals(coffeeName)) {
                        coffeePrice = price[i];
                        break;
                    }
                }
                totalPrice += coffeePrice * quantity;
                lastOrderedItem = coffeeName + " " + quantity;
                System.out.printf("가격은 %d원입니다.\n", coffeePrice * quantity);
            }
        }


        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }
}