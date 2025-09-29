package lab04;
//Q2Triangle class for area and perimeter

class Q2Triangle {
    private double side1, side2, side3;

    // no-arg constructor
    public Q2Triangle() {
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }
    public Q2Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public void setSides(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public double getSide1() { return side1; }
    public double getSide2() { return side2; }
    public double getSide3() { return side3; }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }


    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}

//main class to test
public class q2 {
    public static void main(String[] args) {
        Q2Triangle t1 = new Q2Triangle(4, 5, 6);

        Q2Triangle t2 = new Q2Triangle(1.5, 2.5, 3.5);


        System.out.println("Q2Triangle 1:");
        System.out.println("Sides: " + t1.getSide1() + ", " + t1.getSide2() + ", " + t1.getSide3());
        System.out.println("Perimeter: " + t1.getPerimeter());
        System.out.println("Area: " + t1.getArea());


        System.out.println("\nQ2Triangle 2:");
        System.out.println("Sides: " + t2.getSide1() + ", " + t2.getSide2() + ", " + t2.getSide3());
        System.out.println("Perimeter: " + t2.getPerimeter());
        System.out.println("Area: " + t2.getArea());
    }
}
