package lab03;
import java.util.*;

public class q3{
    //integer sorting
    public static void sort(int[] arr, int n){
        for (int i=0; i<n-1; i++){
            for (int j=0; j<n-i-1; j++){
                if (arr[j]>arr[j+1]){
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
    }

    //integer sorting w reverse ability
    public static void sort(int[] arr, int n, boolean reverse){
        sort(arr,n);
        if (reverse == true){
            int h = (n/2);
            for(int i = 0; i <h; i++){
                int t = arr[i];
                arr[i] = arr[n- i -1];
                arr[n- i -1] = t;
            }
        }
    }

    //alphabetical sort
    public static void sort(String[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Choose type (int/string): ");
        String in = input.nextLine();

        if (in.equalsIgnoreCase("int")) {
            System.out.print("Enter how many numbers: ");
            int n = input.nextInt();
            int[] arr = new int[n];

            System.out.println("Enter " + n + " integers: ");
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }

            System.out.print("Descending order? (True/False): ");
            boolean rev = input.nextBoolean();

            sort(arr, n, rev);

            System.out.println("Sorted integers:");
            for (int i =0; i<n; i++) {
                System.out.println(arr[i] + " ");
            }
        }
        else if (in.equalsIgnoreCase("string")) {
            System.out.print("Enter how many words: ");
            int n = Integer.parseInt(input.nextLine());
            String[] words = new String[n];

            System.out.println("Enter " + n + " words:");
            for (int i = 0; i < n; i++) {
                words[i] = input.nextLine();
            }

           sort(words, n);

            System.out.println("Sorted words:");
            for (int i=0; i<n; i++) {
                System.out.println(words[i] + " ");
            }
        }
    }
}
