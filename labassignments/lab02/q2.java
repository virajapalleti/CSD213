package lab02;
import java.util.Scanner;

//max number n
public class q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many numbers are we using? ");
        int totNums =  input.nextInt();
        int maxNum = 0;

        if(totNums >0) {
            for (int i = 1; i <= totNums; i++) {
                System.out.println("Enter number " + i + ":");
                int nextNum = input.nextInt();

                if (nextNum > maxNum) {
                    maxNum = nextNum;
                }
            }
            System.out.println("The maximum number is " + maxNum);
        }

        else {
            System.out.println("Please enter a positive integer");
        }


    }
}
