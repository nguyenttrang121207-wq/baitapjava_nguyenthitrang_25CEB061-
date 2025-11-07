package Bai4_1;

class Cylinder extends Circle {
    private double height;

    // Constructor mặc định
    public Cylinder() {
        super(); // gọi constructor mặc định của Circle
        this.height = 1.0;
    }
    // Constructor với radius
    public Cylinder(double radius) {
        super();
        this.height = 1.0;
    }

    // Constructor với radius và height
    public Cylinder(double radius, double height) {
        super();
        this.height = height;
    }
    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    // Getter cho height
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume() {
        return getArea() * height; // sử dụng getArea() từ lớp cha
    }
    @Override
    public String toString() {
        return "Cylinder[radius=" + getRadius() +
                ",height=" + height +
                ",color=" + getColor() + "]";
    }
}