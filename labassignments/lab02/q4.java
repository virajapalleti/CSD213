package lab02;
import java.util.Scanner;

// fuzz buzz question
public class q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Pick a number: ");
        int num =  input.nextInt();

        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz ");
            }
            else if (i % 5 == 0) {
                System.out.print("Buzz ");
            }
            else if (i %3 ==0 ) {
                System.out.print("Fizz ");

            }
            else {
                System.out.print(i + " ");
            }
        }
    }
}
