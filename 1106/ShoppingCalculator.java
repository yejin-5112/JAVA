package OpenChallenge6;

import java.util.HashMap;
import java.util.Scanner;

public class ShoppingCalculator {

    public static void main(String[] args) {
        HashMap<String, Integer> productPrices = new HashMap<>();
        productPrices.put("고추장", 3000);
        productPrices.put("만두", 500);
        productPrices.put("새우깡", 1500);
        productPrices.put("콜라", 600);
        productPrices.put("참치캔", 2000);
        productPrices.put("치약", 1000);
        productPrices.put("연어", 2500);
        productPrices.put("삼겹살", 2500);
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("쇼핑 비용을 계산해드립니다. 구입 가능 물건과 가격은 다음과 같습니다.");
        for (String item : productPrices.keySet()) {
            System.out.print("[" + item + "," + productPrices.get(item) + "] ");
        }
        System.out.println();
        
        while (true) {
            System.out.print("물건과 개수를 입력하세요>>");
            String input = scanner.nextLine();
            
            if (input.equals("그만")) {
                break;
            }
            
            String[] items = input.split(" ");
            int totalCost = 0;
            boolean invalidInput = false;
            
            if (items.length % 2 != 0) {
                System.out.println("입력에 문제가 있습니다!");
                continue;
            }
            
            for (int i = 0; i < items.length; i++) {
                if (i % 2 == 0) {
                    String product = items[i];
                    
                    if (!productPrices.containsKey(product)) {
                        System.out.println(product + "은 없는 상품입니다!");
                        invalidInput = true;
                        break;
                    }
                } else {
                    try {
                        int quantity = Integer.parseInt(items[i]);
                        if (quantity <= 0) {
                            System.out.println("잘못된 개수입니다! 개수는 1 이상이어야 합니다.");
                            invalidInput = true;
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("개수를 숫자로 입력해주세요!");
                        invalidInput = true;
                        break;
                    }
                }
            }

            if (!invalidInput) {
                for (int i = 0; i < items.length; i += 2) {
                    String product = items[i];
                    int quantity = Integer.parseInt(items[i + 1]);
                    
                    if (productPrices.containsKey(product)) {
                        totalCost += productPrices.get(product) * quantity;
                    }
                }
                System.out.println("전체 비용은 " + totalCost + "원입니다.");
            }
        }
        
        scanner.close();
    }
}
