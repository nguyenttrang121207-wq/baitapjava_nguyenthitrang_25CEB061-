package Bai5_2;
    public class TestCylinder {
        public static void main(String[] args) {
            Cylinder c1 = new Cylinder(5.0, "blue", 10.0);
            System.out.println("Cylinder c1:");
            System.out.println("  " + c1);
            System.out.printf("  Radius: %.2f, Height: %.2f, Color: %s\n", c1.getRadius(), c1.getHeight(), c1.getColor());
            System.out.printf("  Volume: %.2f\n", c1.getVolume());
            Cylinder c2 = new Cylinder();
            System.out.println("\nCylinder c2 (default):");
            System.out.println("  " + c2);
            c2.setRadius(2.0);
            c2.setHeight(3.0);
            System.out.println("\nCylinder c2 after updates (R=2.0, H=3.0):");
            System.out.println("  " + c2);
            System.out.printf("  Volume: %.2f\n", c2.getVolume());
            System.out.printf("  Surface Area: %.2f\n", c2.getTotalSurfaceArea());
        }
    }

