package OpenChallenge4;

public class ColorPoint2 extends Point {
    private String color;

    public ColorPoint2() {
        super(0, 0); // 기본 생성자: (0, 0) 위치와 기본 색상
        this.color = "WHITE";
    }

    public ColorPoint2(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public ColorPoint2(int x, int y) {
        super(x, y);
        this.color = "WHITE"; // 색상을 기본값으로 설정
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setXY(int x, int y) {
        move(x, y);
    }

    @Override
    public String toString() {
        return color + "색의 (" + getX() + "," + getY() + ")의 점";
    }

    public double getDistance(ColorPoint2 other) {
        int dx = getX() - other.getX();
        int dy = getY() - other.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        ColorPoint2 zeroPoint = new ColorPoint2();
        System.out.println(zeroPoint.toString() + "입니다.");
        
        ColorPoint2 cp = new ColorPoint2(10, 10, "RED");
        
        cp.setColor("BLUE");
        cp.setXY(10, 20);
        System.out.println(cp.toString() + "입니다.");
        
        ColorPoint2 thresholdPoint = new ColorPoint2(100, 100);
        
        System.out.println("cp에서 임계점까지의 거리는 " + cp.getDistance(thresholdPoint));
    }
}