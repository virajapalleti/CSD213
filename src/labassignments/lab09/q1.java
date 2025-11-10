package labassignments.lab09;
import java.util.Random;

class Operation {
    int x;
    private boolean valueSet = false;

    synchronized void getInt() {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted");
            }
        }
        x = new Random().nextInt(0, Integer.MAX_VALUE);
        System.out.println("Produced number: " + x);
        valueSet = true;
        notify();
    }


    synchronized void generateName() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Consumer interrupted");
            }
        }

        System.out.print("In words: ");
        System.out.println(convertToWords(x));
        valueSet = false;
        notify();
    }

    private String convertToWords(int num) {
        if (num == 0)
            return "Zero";

        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"};

        StringBuilder result = new StringBuilder();

        if (num >= 1_000_000_000) {
            result.append(convertThreeDigits(num / 1_000_000_000, ones, teens, tens)).append("Billion ");
            num %= 1_000_000_000;
        }
        if (num >= 1_000_000) {
            result.append(convertThreeDigits(num / 1_000_000, ones, teens, tens)).append("Million ");
            num %= 1_000_000;
        }
        if (num >= 1000) {
            result.append(convertThreeDigits(num / 1000, ones, teens, tens)).append("Thousand ");
            num %= 1000;
        }
        if (num > 0) {
            result.append(convertThreeDigits(num, ones, teens, tens));
        }

        return result.toString().trim();
    }

    private String convertThreeDigits(int num, String[] ones, String[] teens, String[] tens) {
        StringBuilder part = new StringBuilder();

        if (num >= 100) {
            part.append(ones[num / 100]).append(" Hundred ");
            num %= 100;
        }
        if (num >= 20) {
            part.append(tens[num / 10]).append(" ");
            num %= 10;
            part.append(ones[num]).append(" ");
        } else if (num >= 10) {
            part.append(teens[num - 10]).append(" ");
        } else if (num > 0) {
            part.append(ones[num]).append(" ");
        }
        return part.toString();
    }
}

class Producer extends Thread {
    Operation op;

    Producer(Operation op) {
        this.op = op;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            op.getInt();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    Operation op;

    Consumer(Operation op) {
        this.op = op;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            op.generateName();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class q1 {
    public static void main(String[] args) {
        Operation op = new Operation();
        Producer producer = new Producer(op);
        Consumer consumer = new Consumer(op);

        producer.start();
        consumer.start();
    }
}


