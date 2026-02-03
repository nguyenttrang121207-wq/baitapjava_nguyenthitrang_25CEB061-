package Bai6_1;

public class Square extends Rectangle{
        public Square() {
            super(1.0, 1.0);
        }

        public Square(double side) {
            super(side, side);
        }

        public Square(double side, String color, boolean filled) {
            super(side, side, color, filled);
        }

        public double getSide() { return width; }
        public void setSide(double side) {
            this.width = side;
            this.length = side;
        }

        public void setWidth(double side) { setSide(side); }
        public void setLength(double side) { setSide(side); }

        public String toString() {
            return "Square[" + super.toString() + "]";
        }
    }
