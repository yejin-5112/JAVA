package OpenChallenge4;

public class Point3D extends Point {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void moveUp(int distance) {
        z += distance;
    }

    public void moveDown(int distance) {
        z -= distance;
    }

    public void move(int x, int y) {
        super.move(x, y);
    }

    public void move(int x, int y, int z) {
        super.move(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + z + ")의 점";
    }

    public static void main(String[] args) {
        Point3D p = new Point3D(3, 2, 1);
        System.out.println(p.toString() + "입니다.");
        
        p.moveUp(3);
        System.out.println(p.toString() + "입니다.");
        
        p.moveDown(2);
        System.out.println(p.toString() + "입니다.");
        
        p.move(5, 5);
        System.out.println(p.toString() + "입니다.");
        
        p.move(100, 200, 300);
        System.out.println(p.toString() + "입니다.");
    }
}