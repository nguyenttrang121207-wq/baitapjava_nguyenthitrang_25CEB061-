package Bai1_2;
 public class Circle {
        private double radius=1.0f;
        public Circle(double r){
            this.radius = 1.0;
        }
        public double getRadius() {
            return this.radius;
        }
        public void setRadius(double radius) {
            this.radius = radius;
        }
        public double getArea() {
            return this.radius * this.radius*Math.PI;
        }
        public double getCircumference() {
            return 2 * Math.PI * radius;
        }
        @Override
        public String toString() {
            return "Circle[radius=" + this.radius + "]";
        }
    }
