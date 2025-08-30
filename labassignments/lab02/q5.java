package lab02;
import java.util.Scanner;

// to enter the interest rate, numbers years, and loan amount and computes monthly payment


public class q5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Interest Rate: ");
        float IR =  (input.nextFloat() / 100);

        Scanner input2 = new Scanner(System.in);
        System.out.print("Number of Years: ");
        float NY =  input2.nextFloat();

        Scanner input3 = new Scanner(System.in);
        System.out.print("Loan amount: ");
        float LA =  input3.nextFloat();

        float MI = (float) ((LA * IR) / (1- (1 / Math.pow((1+IR), (NY*12)))));

            System.out.printf("%.2f", MI);
    }
}