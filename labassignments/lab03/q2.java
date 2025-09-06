package lab03;
import java.util.*;

//reversing an array
public class q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[11];

        System.out.print("Enter 11 array elements: ");
        for (int i=0; i<11; i++) {
            arr[i] = input.nextInt();
        }
        System.out.print("Entered array: ");
        for (int i=0; i<11; i++) {
            System.out.print(arr[i] + " ");
        }

        for(int i = 0; i <5; i++){
            int t = arr[i];
            arr[i] = arr[11- i -1];
            arr[11- i -1] = t;
        }
        System.out.print("\nReversed array: ");
        for(int i=0; i<11; i++){
            System.out.print(arr[i] + " ");
        }

    }
}
