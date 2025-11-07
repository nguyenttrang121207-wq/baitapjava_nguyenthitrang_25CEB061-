package Bai5_1;

public class TestLine {
        public static void main(String[] args) {
            Line l1 = new Line(0, 0, 3, 4);
            System.out.println("Line l1: " + l1);
            System.out.println("Length l1: " + l1.getLength());
            Point p1 = new Point(1, 1);
            Point p2 = new Point(10, 10);
            Line l2 = new Line(p1, p2);
            System.out.println("Line l2: " + l2);
            l2.setEndX(5);
            System.out.println("Line l2 after change: " + l2);
            System.out.println("Gradient l2: " + l2.getGradient() + " radians");
        }
    }
