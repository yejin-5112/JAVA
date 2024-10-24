package OpenChallenge4;

import java.util.Scanner;

class BaseArray {
    protected int array [];
    protected int nextIndex = 0;

    public BaseArray(int size) {
        array = new int[size];
    }

    public int length() {
        return array.length;
    }

    public void add(int n) {
        if (nextIndex == array.length) return;
        array[nextIndex] = n;
        nextIndex++;
    }

    public void print() {
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

class SortedArray extends BaseArray {

    public SortedArray(int size) {
        super(size);
    }

    @Override
    public void add(int n) {
        if (nextIndex == array.length) return;

        // 추가할 값을 삽입할 위치 찾기
        int insertIndex = nextIndex;
        while (insertIndex > 0 && array[insertIndex - 1] > n) {
            if (insertIndex < array.length) {
                array[insertIndex] = array[insertIndex - 1]; // 오른쪽으로 이동
            }
            insertIndex--;
        }
        
        // 값을 추가
        array[insertIndex] = n;
        nextIndex++;
    }
}

public class MaxHeap {
    public static void main(String[] args) {
        SortedArray sArray = new SortedArray(10);
        Scanner scanner = new Scanner(System.in);
        System.out.print(">>");
        
        for (int i = 0; i < sArray.length(); i++) {
            int n = scanner.nextInt();
            sArray.add(n);
        }
        
        sArray.print();
        scanner.close();
    }
}
