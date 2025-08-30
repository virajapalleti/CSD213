package lab02;
import java.util.Scanner;


//binary search

public class q8 {
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

    public static int BSearch(double[] arr, double key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] arr = new double[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = input.nextDouble();
        }
        insertionSort(arr);
        double key = input.nextDouble();
        int result = BSearch(arr, key);
        if (result != -1)
            System.out.println("Element has been found at index: " + result);
        else
            System.out.println("Element not found");
    }
}