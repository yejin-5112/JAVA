package OpenChallenge4;

interface Shape {
    double PI = 3.14;
    void draw();
    double getArea();
    
    default void redraw() {
        System.out.print("--- 다시 그립니다. ");
        draw();
    }
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("반지름이 " + radius + "인 원");
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }
}

class Oval implements Shape {
    private double majorAxis;
    private double minorAxis;

    public Oval(double majorAxis, double minorAxis) {
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }

    @Override
    public void draw() {
        System.out.println(majorAxis + "X" + minorAxis + "에 내접하는 타원");
    }

    @Override
    public double getArea() {
        return PI * majorAxis * minorAxis / 4;
    }
}

class Rect implements Shape {
    private double width;
    private double height;

    public Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println(width + "X" + height + "에 크기의 사각형");
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

public class ShapeEx {
    public static void main(String[] args) {
        Shape[] list = new Shape[3];
        list[0] = new Circle(5);
        list[1] = new Oval(20, 30);
        list[2] = new Rect(10, 40);

        for (int i = 0; i < list.length; i++) {
            list[i].redraw();
        }

        for (int i = 0; i < list.length; i++) {
            System.out.println("면적은 " + list[i].getArea());
        }
    }
}
