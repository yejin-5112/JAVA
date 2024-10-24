package OpenChallenge4;
//보류 323페이지의 6번문

public class PositivePoint extends Point {
    public PositivePoint(int x, int y) {
        super(x < 1 ? 1 : x, y < 1 ? 1 : y);
    }

    @Override
    public void move(int x, int y) {
        if (x > 0 && y > 0) {
            super.move(x, y);
        }
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")의 점";
    }

    public static void main(String[] args) {
        PositivePoint p = new PositivePoint(10, 10); // (10,10)의 점
        p.move(5, 5);
        System.out.println(p.toString() + "입니다."); // (10,10)의 점 출력

        p.move(2, -2); // 점 p는 양수 공간만 가능하므로 이동 없음
        System.out.println(p.toString() + "입니다."); // 여전히 (2,-2)의 점 출력

        PositivePoint q = new PositivePoint(-10, -10); // 음수 점 불가, 디폴트 (1,1)의 점 생성
        System.out.println(q.toString() + "입니다."); // (1,1)의 점 출력
    }
}