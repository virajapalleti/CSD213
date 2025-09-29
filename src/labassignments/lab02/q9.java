package lab02;
import java.util.Scanner;

class BankAccount {
    String depositorName;
    String accountNumber;
    String accountType;
    double balance;

    void assignValues(String name, String accNum, String accType, double bal) {
        depositorName = name;
        accountNumber = accNum;
        accountType = accType;
        balance = bal;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("New balance: " + balance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    void display() {
        System.out.println("Account Holder: " + depositorName);
        System.out.println("Balance: " + balance);
    }
}

public class q9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankAccount acc = new BankAccount();

        while (true) {
            System.out.println("\nEnter your choice:");
            System.out.println("1. Assign Initial Values");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account Holder Name and Balance");
            System.out.println("5. Exit");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = input.nextLine();
                    System.out.print("Enter account number: ");
                    String accNum = input.nextLine();
                    System.out.print("Enter account type: ");
                    String accType = input.nextLine();
                    System.out.print("Enter initial balance: ");
                    double bal = input.nextDouble();
                    acc.assignValues(name, accNum, accType, bal);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmt = input.nextDouble();
                    acc.deposit(depositAmt);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmt = input.nextDouble();
                    acc.withdraw(withdrawAmt);
                    break;

                case 4:
                    acc.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
