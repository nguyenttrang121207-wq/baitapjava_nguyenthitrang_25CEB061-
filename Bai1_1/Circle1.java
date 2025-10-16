package Bai1_1;

public class Circle1 {
        private double radius;
        private String color;
        public Circle1() {
            radius = 1.0;
            color = "red";
        }
        public Circle1(double r) {
            radius = r;
            color = "red";
        }
        public double getRadius() {
            return radius;
        }
        public double getArea() {
            return radius*radius*Math.PI;
        }
    }

