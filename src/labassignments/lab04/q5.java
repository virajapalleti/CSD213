package lab04;
import java.util.*;

//airplane
public class q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean[] seats = new boolean[10];
        int choice;


        while (true) {
            System.out.println("Please type 1 for First Class or 2 for Economy (0 to exit): ");
            choice = input.nextInt();

            if (choice == 0) break;

            if (choice == 1) {
                if (!assignSeat(seats, 0, 5, "First Class")) {
                    // if full
                    System.out.println("First Class is full. Do you want Economy instead? (y/n)");
                    char ans = input.next().charAt(0);
                    if (ans == 'y') {
                        if (!assignSeat(seats, 5, 10, "Economy")) {
                            System.out.println("Economy is also full. Sorry. Next flight leaves in 3 hours.");
                        }
                    } else {
                        System.out.println("Next flight leaves in 3 hours!!!");
                    }
                }
            } else if (choice == 2) {
                if (!assignSeat(seats, 5, 10, "Economy")) {
                    // economy full
                    System.out.println("Economy is full. Do you want First Class instead? (y/n)");
                    char ans = input.next().charAt(0);
                    if (ans == 'y' || ans == 'Y') {
                        if (!assignSeat(seats, 0, 5, "First Class")) {
                            System.out.println("First Class is also full. Next flight leaves in 3 hours.");
                        }
                    } else {
                        System.out.println("Next flight leaves in 3 hours.");
                    }
                }
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }

        input.close();
    }

    // helper method to assign seat
    public static boolean assignSeat(boolean[] seats, int start, int end, String section) {
        for (int i = start; i < end; i++) {
            if (!seats[i]) {
                seats[i] = true;
                System.out.println("Boarding pass: Seat " + (i + 1) + " (" + section + ")");
                return true;
            }
        }
        return false;
    }
}
