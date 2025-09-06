
package lab03;
import java.util.*;

class Circle2D {
    private double x;
    private double y;
    private double radius;

    public Circle2D() {
        x = 0;
        y = 0;
        radius = 1;
    }

    public Circle2D(double a, double b, double r) {
        x = a;
        y = b;
        radius = r;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getRadius() { return radius; }


    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean contains(double px, double py) {
        double dist = Math.sqrt((px - x)*(px - x) + (py - y)*(py - y));
        return dist <= radius;
    }

    public boolean contains(Circle2D c) {
        double dist = Math.sqrt((c.x - x)*(c.x - x) + (c.y - y)*(c.y - y));
        return dist + c.radius <= radius;
    }

    public boolean overlaps(Circle2D c) {
        double dist = Math.sqrt((c.x - x)*(c.x - x) + (c.y - y)*(c.y - y));
        return dist < (radius + c.radius);
    }
}

public class q5 {
    public static void main(String[] args) {
        Circle2D c1 = new Circle2D(2, 2, 5.5);

        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());

        System.out.println("c1.contains(3,3): " + c1.contains(3, 3));
        System.out.println("c1.contains(new Circle2D(4,5,10.5)): "
                + c1.contains(new Circle2D(4, 5, 10.5)));
        System.out.println("c1.overlaps(new Circle2D(3,5,2.3)): "
                + c1.overlaps(new Circle2D(3, 5, 2.3)));
    }
}
