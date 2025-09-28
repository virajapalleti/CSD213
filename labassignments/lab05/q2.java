package lab05;
import java.util.*;

class Circle {
    private double radius;
    private String color;

    public Circle() {
        radius = 1.0;
        color = "red";
    }

    public Circle(double r) {
        radius = r;
        color = "red";
    }
    public Circle(double r, String c) {
        radius = r;
        color = c;
    }
    public double getRadius() {
        return radius;
    }
    public String getColor() {
        return color;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public String info() {
        return "Circle[radius=" + radius + ", color=" + color + "]";
    }
}

class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        super();
        height = 1.0;
    }
    public Cylinder(double r) {
        super(r);
        height = 1.0;
    }
    public Cylinder(double r, double h) {
        super(r);
        height = h;
    }
    public Cylinder(double r, double h, String c) {
        super(r, c);
        height = h;
    }
    public double getHeight() {
        return height;
    }
    public double getVolume() {
        return getArea() * height;
    }

    @Override
    public String info() {
        return "Cylinder[height=" + height + ", " + super.info() + "]";
    }
}

public class q2 {
    public static void main(String[] args) {
        Circle c = new Circle(5, "blue");
        System.out.println(c.info());
        System.out.println("Area = " + c.getArea());

        Cylinder cy = new Cylinder(5, 10, "green");
        System.out.println(cy.info());
        System.out.println("Area = " + cy.getArea());
        System.out.println("Volume = " + cy.getVolume());
    }
}
