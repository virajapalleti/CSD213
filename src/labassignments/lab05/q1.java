package lab05;

class QueueOfIntegers {
    private int[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 10;

    public QueueOfIntegers() {
        elements = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public QueueOfIntegers(int capacity) {
        elements = new int[capacity];
        size = 0;
    }

    public void enqueue(int v) {
        if (size == elements.length) {
            System.out.println("Queue is full!");
            return;
        }
        elements[size] = v;
        size++;
    }

    public int dequeue() {
        if (empty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int removed = elements[0];
        for (int i = 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        return removed;
    }

    public boolean empty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}

public class q1 {
    public static void main(String[] args) {
        QueueOfIntegers q = new QueueOfIntegers();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Removed: " + q.dequeue());
        System.out.println("Removed: " + q.dequeue());

        System.out.println("Queue size: " + q.getSize());
        System.out.println("Is empty? " + q.empty());
    }
}
