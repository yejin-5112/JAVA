package OpenChallenge3;

import java.util.ArrayList;

public class Average {
    private ArrayList<Integer> numbers;

    public Average() {
        numbers = new ArrayList<>();
    }

    public void put(int num) {
        if (numbers.size() < 10) {
            numbers.add(num);
        } else {
            System.out.println("최대 10개까지만 저장할 수 있습니다.");
        }
    }

    public void showAll() {
        System.out.println("***** 저장된 데이터 모두 출력 *****");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public double getAvg() {
        if (numbers.isEmpty()) return 0;
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.size();
    }

    public static void main(String[] args) {
        Average avg = new Average();
        avg.put(10);
        avg.put(15);
        avg.put(100);
        avg.showAll();
        System.out.println("평균은 " + avg.getAvg());
    }
}