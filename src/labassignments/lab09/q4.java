package labassignments.lab09;
import java.util.*;

class SleepThread extends Thread {
    private String name;
    private long time;

    SleepThread(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public void run() {
        try {
            System.out.println(name + " sleeping for " + time + " milliseconds");
            Thread.sleep(time);
            System.out.println(name + " woke up after " + time + " milliseconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x, y, z (in milliseconds): ");
        long x = sc.nextLong();
        long y = sc.nextLong();
        long z = sc.nextLong();


        System.out.println("Main thread sleeping for " + x + " milliseconds");
        try {
            Thread.sleep(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread woke up after " + x + " milliseconds");


        SleepThread t1 = new SleepThread("T1", y);
        SleepThread t2 = new SleepThread("T2", z);

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
    }
}