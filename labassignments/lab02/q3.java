package lab02;
import java.util.Scanner;

// print all primes in an input array
public class q3 {

    //to check for prime
    static boolean checkPrime(int n){
        for (int i=2; i<n; i++)
        {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many numbers are we using? ");
        int totNums =  input.nextInt();

        int array[] = new int[totNums];

        for (int i = 0; i < totNums; i++)
        {
            System.out.println("Enter number " + i+1 + ":");
            array[i] = input.nextInt();
        }

        System.out.println("The prime numbers from the array are:");
        for (int i=0; i<totNums; i++)
        {
            if (checkPrime(array[i])){
                System.out.println(array[i] + " ");
            }
        }

    }
}
