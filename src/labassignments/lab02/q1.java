package lab02;
import java.util.Scanner;

// factorial of a number
public class q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        long num = input.nextLong();
        long result = 1;

        for (long i = 1; i <= num; i++)
        {
            result *= i;

        }
        System.out.println("The factorial is: "+ result);
    }
}
