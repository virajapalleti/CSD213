package lab02;
import java.util.Scanner;


public class q7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] nums = new double[10];

        System.out.println("Enter 10 double numbers:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            nums[i] = input.nextDouble();
        }

        insertionSort(nums);

        System.out.println("Sorted numbers are:");
        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void insertionSort(double[] arr) {
        for (int i = 1; i < arr.length; i++) {
            double element = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > element) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = element;
        }
    }
}
