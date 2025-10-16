package Bai1_1;

public class TestCircle {
        public static void main(String[] args) {
            Circle1 c1 = new Circle1();
            System.out.println("The circle has radius of "
                    + c1.getRadius() + " and area of " + c1.getArea());
            Circle1 c2 = new Circle1(2.0);
            System.out.println("The circle has radius of "
                    + c2.getRadius() + " and area of " + c2.getArea());
        }
    }
