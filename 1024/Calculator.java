package OpenChallenge4;

import java.util.Scanner;

abstract class Calc {
    protected String errorMsg;
    protected int a, b;

    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public abstract int calculate();
}

class Add extends Calc {
    @Override
    public int calculate() {
        return a + b;
    }
}

class Sub extends Calc {
    @Override
    public int calculate() {
        return a - b;
    }
}

class Mul extends Calc {
    @Override
    public int calculate() {
        return a * b;
    }
}

class Div extends Calc {
    @Override
    public int calculate() {
        if (b == 0) {
            errorMsg = "0으로 나눌 수 없음.";
            throw new ArithmeticException(errorMsg);
        }
        return a / b;
    }
}

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("두 정수와 연산자를 입력하시오>> ");
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            String operator = scanner.next();

            Calc calculator = null;

            switch (operator) {
                case "+":
                    calculator = new Add();
                    break;
                case "-":
                    calculator = new Sub();
                    break;
                case "*":
                    calculator = new Mul();
                    break;
                case "/":
                    calculator = new Div();
                    break;
                default:
                    System.out.println("지원하지 않는 연산자입니다.");
                    continue;
            }

            calculator.setValue(num1, num2);

            try {
                int result = calculator.calculate();
                System.out.println("계산 결과 " + result);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage() + " 프로그램 종료");
                break;
            }
        }

        scanner.close();
    }
}
