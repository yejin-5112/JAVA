package OpenChallenge4;

import java.util.Scanner;

interface IStack {
    int capacity();
    int length();
    boolean push(String val);
    String pop();
}

class StringStack implements IStack {
    private String[] stack;
    private int top = -1;

    public StringStack(int capacity) {
        stack = new String[capacity];
    }

    @Override
    public int capacity() {
        return stack.length;
    }

    @Override
    public int length() {
        return top + 1;
    }

    @Override
    public boolean push(String val) {
        if (length() >= capacity()) {
            System.out.println("스택이 꽉 차서 " + val + " 저장 불가");
            return false;
        }
        stack[++top] = val;
        return true;
    }

    @Override
    public String pop() {
        if (top < 0) {
            return null; // 스택이 비어있음
        }
        return stack[top--];
    }

    public String[] getStack() {
        String[] currentStack = new String[length()];
        System.arraycopy(stack, 0, currentStack, 0, length());
        return currentStack;
    }
}

public class StackApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("스택 용량>>");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리

        StringStack stringStack = new StringStack(capacity);

        while (true) {
            System.out.print("문자열 입력>>");
            String input = scanner.nextLine();

            if (input.equals("그만")) {
                break;
            }

            stringStack.push(input);
        }

        System.out.print("스택에 저장된 문자열 팝 : ");
        while (stringStack.length() > 0) {
            System.out.print(stringStack.pop() + " ");
        }
        scanner.close();
    }
}
