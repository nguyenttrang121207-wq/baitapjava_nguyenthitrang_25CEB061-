package Bai5_1;

public class TestPoint {
    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        System.out.println("Original Point: " + p1);
        p1.setXY(100, 10);
        System.out.println("Modified Point (setXY): " + p1);
        p1.setX(50);
        System.out.println("Modified Point (setX): " + p1);
        System.out.println("X-coordinate: " + p1.getX());
    }
}