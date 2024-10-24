package OpenChallenge4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Shape {
    public abstract String getName();
}

class Line extends Shape {
    @Override
    public String getName() {
        return "Line";
    }
}

class Rect extends Shape {
    @Override
    public String getName() {
        return "Rect";
    }
}

class Circle extends Shape {
    @Override
    public String getName() {
        return "Circle";
    }
}

class GraphicEditor {
    private List<Shape> shapes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");
        while (true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>> ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertShape();
                    break;
                case 2:
                    deleteShape();
                    break;
                case 3:
                    showShapes();
                    break;
                case 4:
                    System.out.println("Beauty Graphic Editor를 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력해 주세요.");
            }
        }
    }

    private void insertShape() {
        System.out.print("Line(1), Rect(2), Circle(3)>> ");
        int shapeType = scanner.nextInt();
        Shape shape = null;

        switch (shapeType) {
            case 1:
                shape = new Line();
                break;
            case 2:
                shape = new Rect();
                break;
            case 3:
                shape = new Circle();
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                return;
        }

        shapes.add(shape);
        System.out.println(shape.getName() + " 도형이 삽입되었습니다.");
    }

    private void deleteShape() {
        System.out.print("삭제할 도형의 위치>> ");
        int index = scanner.nextInt() - 1;

        if (index < 0 || index >= shapes.size()) {
            System.out.println("삭제할 수 없습니다.");
            return;
        }

        shapes.remove(index);
        System.out.println("도형이 삭제되었습니다.");
    }

    private void showShapes() {
        if (shapes.isEmpty()) {
            System.out.println("현재 도형이 없습니다.");
            return;
        }
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println(shapes.get(i).getName());
        }
    }

    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        editor.run();
    }
}
