package labassignments.lab06;
import java.util.Scanner;

class forDivisionBy0 extends Exception {
    public String toString() {
        return "Error: We cant divide by 0";
    }
}

class NegSqrt extends Exception {
    public String toString() {
        return "Error: We cant do sqrt of a -ve number";
    }
}

class NegFactorial extends Exception {
    public String toString() {
        return "Error: We cant do the factorial of a -ve number";
    }
}



public class q3 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        while (true) {
            //System.out.println("\n--- Menu ---");
            System.out.println("1. Division");
            System.out.println("2. Square Root");
            System.out.println("3. Factorial");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.print("numerator: ");
                int a = input.nextInt();
                System.out.print("denominator: ");
                int b = input.nextInt();
                if (b == 0) throw new forDivisionBy0();
                System.out.println("Result = " + (a / b));

            } else if (choice == 2) {
                System.out.print("Enter number: ");
                int n = input.nextInt();
                if (n < 0) throw new NegSqrt();
                System.out.println("Square root = " + Math.sqrt(n));

            } else if (choice == 3) {
                System.out.print("Enter number: ");
                int f = input.nextInt();
                if (f < 0) throw new NegFactorial();
                int fact = 1;
                for (int i = 1; i <= f; i++) {
                    fact *= i;
                }
                System.out.println("Factorial = " + fact);
            } else if (choice == 4) {
                System.out.println("bye bye");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }

        input.close();
    }
}

