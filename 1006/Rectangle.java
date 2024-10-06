package OpenChallenge3;

public class Rectangle {
    private int x; // 사각형의 왼쪽 아래 x 좌표
    private int y; // 사각형의 왼쪽 아래 y 좌표
    private int width; // 사각형의 너비
    private int height; // 사각형의 높이

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void show() {
        System.out.printf("(%d, %d)에서 크기가 %dX%d인 사각형\n", x, y, width, height);
    }

    public boolean isSquare() {
        return width == height;
    }

    public boolean contains(Rectangle other) {
        return this.x <= other.x && this.y <= other.y &&
               (this.x + this.width) >= (other.x + other.width) &&
               (this.y + this.height) >= (other.y + other.height);
    }

    public static void main(String[] args) {
        Rectangle a = new Rectangle(3, 3, 6, 6);
        Rectangle b = new Rectangle(4, 4, 2, 3);
        
        a.show();
        if (a.isSquare()) {
            System.out.println("a는 정사각형입니다.");
        } else {
            System.out.println("a는 직사각형입니다.");
        }
        if (a.contains(b)) {
            System.out.println("a는 b를 포함합니다.");
        }
    }
}