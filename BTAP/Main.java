package BTAP;
public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng Circle
        Circle circle = new Circle(5.0, "blue", true);
        System.out.println(circle);
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());

        // Tạo đối tượng Rectangle
        Rectangle rectangle = new Rectangle(4.0, 6.0, "green", false);
        System.out.println(rectangle);
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());

        // Tạo đối tượng Square
        Square square = new Square(4.0, "yellow", true);
        System.out.println(square);
        System.out.println("Area: " + square.getArea());
        System.out.println("Perimeter: " + square.getPerimeter());
    }
}

