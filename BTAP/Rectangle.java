package BTAP;
public class Rectangle extends Shape {
    private double width;
    private double length;

    // Constructor mặc định
    public Rectangle() {
        this.width = 1.0;
        this.length = 1.0;
    }

    // Constructor với chiều rộng và chiều dài
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    // Constructor với chiều rộng, chiều dài, màu sắc và trạng thái filled
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    // Getter và Setter
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Rectangle[Shape[color=" + getColor() + ", filled=" + isFilled() + "], width=" + width + ", length=" + length + "]";
    }
}

