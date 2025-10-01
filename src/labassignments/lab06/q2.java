package labassignments.lab06;
import java.util.Scanner;

class InsufficientDeposit extends Exception {
    public InsufficientDeposit(String msg) {
        super(msg);
    }

    public String toString() {
        return "InsufficientDepositException: " + getMessage();
    }
}

// Custom exception for insufficient tenure
class InsufficientTenure extends Exception {
    public InsufficientTenure(String msg) {
        super(msg);
    }

    public String toString() {
        return "InsufficientTenureException: " + getMessage();
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter deposit amount: ");
        double amount = input.nextDouble();

        System.out.print("Enter tenure (in months): ");
        int tenure = input.nextInt();
        try {
            try {
                if (amount < 50000) {
                    throw new InsufficientDeposit("Deposit must be at least 50,000");
                }

                try {
                    if (tenure < 12) {
                        throw new InsufficientTenure("Tenure must be at least 12 months");
                    }

                    double interest = amount * 0.075 * (tenure / 12.0);
                    double maturityAmount = amount + interest;

                    System.out.println("Deposit Amount: " + amount);
                    System.out.println("Tenure: " + tenure + " months");
                    System.out.println("Interest Rate: 7.5% per annum");
                    System.out.println("Interest Earned: " + interest);
                    System.out.println("Maturity Amount: " + maturityAmount);

                } catch (InsufficientTenure e) {
                    System.out.println("Condition not met: Minimum tenure is 12 months");
                }

            } catch (InsufficientDeposit e) {
                try {
                    if (tenure < 12) {
                        throw new InsufficientTenure("Tenure also insufficient");
                    }
                    System.out.println("Condition not met: Minimum deposit is 50000");
                } catch (InsufficientTenure te) {
                    System.out.println("Condition not met: Both deposit amount(min is 50K) and tenure are insufficient(min is 12 months)");
                }
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        input.close();
    }
}