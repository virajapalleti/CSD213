package labassignments.lab09;
import java.util.*;

class Generator implements Runnable {
    int n;
    String name;

    Generator(int n, String name) {
        this.n = n;
        this.name = name;
    }

    public void run() {
        switch (name) {
            case "UptoN":
                uptoN();
                break;
            case "Even":
                evenN();
                break;
            case "Odd":
                oddN();
                break;
        }
    }

    synchronized void uptoN() {
        System.out.println(Thread.currentThread().getName() + ": Printing numbers up to " + n);
        for (int i = 1; i <= n; i++) System.out.print(i + " ");
        System.out.println();
    }

    synchronized void evenN() {
        System.out.println(Thread.currentThread().getName() + ": Printing even numbers up to " + n);
        for (int i = 2; i <= n; i += 2) System.out.print(i + " ");
        System.out.println();
    }

    synchronized void oddN() {
        System.out.println(Thread.currentThread().getName() + ": Printing odd numbers up to " + n);
        for (int i = 1; i <= n; i += 2) System.out.print(i + " ");
        System.out.println();
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        Thread t1 = new Thread(new Generator(n, "UptoN"), "UptoN Thread");
        Thread t2 = new Thread(new Generator(n, "Even"), "Even Thread");
        Thread t3 = new Thread(new Generator(n, "Odd"), "Odd Thread");


        t1.setPriority(Thread.NORM_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("All threads finished.");
    }
}
