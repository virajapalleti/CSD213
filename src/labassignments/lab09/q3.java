package labassignments.lab09;
import java.util.*;

class SharedResource {
    boolean letterTurn = false;
}

class NumberThread extends Thread {
    SharedResource shared;
    int n;

    NumberThread(SharedResource s, int n) {
        shared = s;
        this.n = n;
    }

    public void run() {
        synchronized (shared) {
            for (int i = 1; i <= n; i++) {
                try {
                    while (shared.letterTurn) {
                        shared.wait();
                    }
                    for (int j = 1; j <= i; j++) {
                        System.out.println(j);
                    }
                    shared.letterTurn = true;
                    shared.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class LetterThread extends Thread {
    SharedResource shared;
    int n;

    LetterThread(SharedResource s, int n) {
        shared = s;
        this.n = n;
    }

    public void run() {
        synchronized (shared) {
            for (int i = 1; i <= n; i++) {
                try {
                    while (!shared.letterTurn) {
                        shared.wait();
                    }
                    System.out.println(i + "  " + (char)(64 + i));
                    shared.letterTurn = false;
                    shared.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class q3 {
    public static void main(String[] args) {
        int n = 26;
        SharedResource shared = new SharedResource();

        Thread numbers = new NumberThread(shared, n);
        Thread letters = new LetterThread(shared, n);

        numbers.start();
        letters.start();
    }
}
