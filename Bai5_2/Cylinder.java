package Bai5_2;
    public class Cylinder {
        private Circle base;
        private double height;
        public Cylinder() {
            base = new Circle();
            height = 1.0;
        }
        public Cylinder(double radius, double height) {
            this.base = new Circle(radius);
            this.height = height;
        }
        public Cylinder(double radius, String color, double height) {
            this.base = new Circle(radius, color);
            this.height = height;
        }
        public double getRadius() {
            return base.getRadius();
        }
        public String getColor() {
            return base.getColor();
        }
        public double getHeight() {
            return height;
        }
        public void setHeight(double height) {
            this.height = height;
        }

        @Override
        public String toString() {
            return "Cylinder[height=" + height + ", base=" + base.toString() + "]";
        }
        public double getVolume() {
            return base.getArea() * height;
        }
        public double getTotalSurfaceArea() {
            // 2 * (base area) + (circumference * height)
            return 2 * base.getArea() + (2 * Math.PI * base.getRadius() * height);
        }

        public void setRadius(double v) {
        }
    }

