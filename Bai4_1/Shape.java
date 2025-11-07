package Bai4_1;package Bai4_1;

public abstract class Shape {
    private String color;
    private boolean filled;

    // Constructor mặc định
    public Shape() {
        this.color = "red";
        this.filled = true;
    }

    // Constructor với tham số
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // Getter và Setter
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // Phương thức trừu tượng
    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "Shape[color=" + color + ", filled=" + filled + "]";
    }
}

