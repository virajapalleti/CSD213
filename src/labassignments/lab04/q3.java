package lab04;
import java.util.*;


abstract class Q3Shape {
    public abstract String getDescription();
}

// 2D Shape
abstract class TwoDimensionalQ3Shape extends Q3Shape {
    public abstract double getArea();
}

// 3D Shape
abstract class ThreeDimensionalQ3Shape extends Q3Shape {
    public abstract double getArea();
    public abstract double getVolume();
}

// Circle (2D)
class Q3Circle extends TwoDimensionalQ3Shape {
    private double radius;

    public Q3Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getDescription() {
        return "Circle with radius " + radius;
    }
}

// Square (2D)
class Square extends TwoDimensionalQ3Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String getDescription() {
        return "Square with side " + side;
    }
}

// Sphere (3D)
class Sphere extends ThreeDimensionalQ3Shape {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() { // surface area
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3) * Math.PI * radius * radius * radius;
    }

    @Override
    public String getDescription() {
        return "Sphere with radius " + radius;
    }
}

// Cube (3D)
class Cube extends ThreeDimensionalQ3Shape {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double getArea() { // surface area
        return 6 * side * side;
    }

    @Override
    public double getVolume() {
        return side * side * side;
    }

    @Override
    public String getDescription() {
        return "Cube with side " + side;
    }
}

// Test program
public class q3 {
    public static void main(String[] args) {
        Q3Shape[] q3Shapes = new Q3Shape[4];
        q3Shapes[0] = new Q3Circle(5);
        q3Shapes[1] = new Square(4);
        q3Shapes[2] = new Sphere(3);
        q3Shapes[3] = new Cube(2);


        for (Q3Shape s : q3Shapes) {
            System.out.println("\n" + s.getDescription());

            if (s instanceof TwoDimensionalQ3Shape) {
                TwoDimensionalQ3Shape t = (TwoDimensionalQ3Shape) s;
                System.out.println("Area = " + t.getArea());
            } else if (s instanceof ThreeDimensionalQ3Shape) {
                ThreeDimensionalQ3Shape t = (ThreeDimensionalQ3Shape) s;
                System.out.println("Surface Area = " + t.getArea());
                System.out.println("Volume = " + t.getVolume());
            }
        }
    }
}