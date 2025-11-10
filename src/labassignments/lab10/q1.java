package labassignments.lab10;
import java.util.*;

public class q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double invest, rate;
        int years;
        System.out.print("Enter investment amount: ");
        invest = sc.nextDouble();
        System.out.print("Enter annual interest rate in %: ");
        rate = sc.nextDouble();
        System.out.print("Enter number of years: ");
        years = sc.nextInt();
        rate = rate / 100;
        double value = invest * Math.pow((1 + rate), years);
        System.out.printf("Future value is: %.2f", value);
        sc.close();
    }
}
