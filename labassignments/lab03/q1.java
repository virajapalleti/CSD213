package lab03;
import java.util.Scanner;

//recursive funcs for an array
public class q1 {
    public static int largestOdd(int[] arr, int n, int index)
    {
        if (index == n) return Integer.MIN_VALUE;

        int t = arr[index];
        int next = largestOdd(arr, n, index+1);
        if (t%2 != 0 && t > next) {
            return t;
        }
        return next;
    }

    public static int smallestEven(int[] arr, int n, int index)
    {
        if (index==n) return Integer.MAX_VALUE;

        int t = arr[index];
        int next = smallestEven(arr, n, index+1);
        if (t%2 == 0 && t <next) {
            return t;
        }
        return next;
    }

    public static int largestPrime(int[] arr, int n, int index)
    {
        if (index==n) return Integer.MIN_VALUE;
        int max =1;

        int t = arr[index];
        for (int i=2; i<=t; i++){
            while (t%i==0){
                max = i;
                t = t/i;
            }
        }
        int next = largestPrime(arr, n, index+1);
        if (max>next){
            return max;
        }
        else return next;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();

        int even = smallestEven(arr, n, 0);
        System.out.println("Smallest Even Number in the Array is:" + even);
        int odd = largestOdd(arr, n, 0);
        System.out.println("\nLargest Odd Number in the Array is:" + odd);
        int prime = largestPrime(arr, n, 0);
        System.out.println("\nLargest Prime factor in the Array is:" + prime);
    }
}
