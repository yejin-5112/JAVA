package OpenChallenge4;

public class Point3DColor extends Point {
    private int z;
    private String color;

    public Point3DColor(int x, int y, int z, String color) {
        super(x, y);
        this.z = z;
        this.color = color;
    }

    public void move(Point3DColor other) {
        super.move(other.getX(), other.getY());
        // z 값을 변경하지 않음
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + z + ")" + color + "점";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point3DColor)) return false;

        Point3DColor other = (Point3DColor) obj;
        return this.getX() == other.getX() && this.getY() == other.getY() && this.z == other.z && this.color.equals(other.color);
    }

    public static void main(String[] args) {
        Point3DColor p = new Point3DColor(10, 20, 0, "RED");
        System.out.println(p.toString() + "입니다.");

        Point3DColor q = new Point3DColor(1, 2, 0, "RED"); 
        p.move(q);
        System.out.println(p.toString() + "입니다.");
        
        Point3DColor r = new Point3DColor(1, 2, 0, "RED");
        if (p.equals(r)) System.out.println("예. 같은 위치 같은 색깔의 점입니다.");
        else System.out.println("아니오.");
    }
}