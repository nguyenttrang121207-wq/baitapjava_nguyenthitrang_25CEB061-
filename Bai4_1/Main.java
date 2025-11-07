package Bai4_1;

public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(2.0, "blue");
        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());

        Cylinder cy1 = new Cylinder(2.0, 5.0, "green");
        System.out.println(cy1);
        System.out.println("Volume: " + cy1.getVolume());
    }
}