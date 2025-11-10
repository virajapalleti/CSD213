package labassignments.lab08;

class Ticket {
    private String eventName;
    private double price;

    public Ticket(String eventName, double price) {
        this.eventName = eventName;
        this.price = price;
    }

    public String getEventName() {
        return eventName;
    }

    public double getPrice() {
        return price;
    }
}

class Event {
    private String eventName;
    private String venue;

    public Event(String eventName, String venue) {
        this.eventName = eventName;
        this.venue = venue;
    }

    public String getEventName() {
        return eventName;
    }

    public String getVenue() {
        return venue;
    }
}

class Student {
    private String name;
    private String studentID;

    public Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public String getStudentID() {
        return studentID;
    }
}

class Booking {
    private Student s;
    private Event e;
    private Ticket[] arr;
    private int count;

    public Booking(Student s, Event e, int size) {
        this.s = s;
        this.e = e;
        this.arr = new Ticket[size];
        this.count = 0;
    }

    public void addTicket(Ticket t) {
        if (count < arr.length) {
            arr[count] = t;
            count++;
        }
    }

    public void addTicket(Ticket t, int qty) {
        for (int i = 0; i < qty; i++) {
            addTicket(t);
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += arr[i].getPrice();
        }
        return total;
    }

    public void printBooking() {
        System.out.println("Student: " + s.getName() + " (ID: " + s.getStudentID() + ")");
        System.out.println("Event: " + e.getEventName() + " at " + e.getVenue());
        System.out.println("Tickets:");
        for (int i = 0; i < count; i++) {
            System.out.println("  - " + arr[i].getEventName() + " - Rs. " + arr[i].getPrice());
        }
        System.out.println("Total: Rs. " + calculateTotal());
        System.out.println();
    }
}

class GeneralBooking extends Booking {
    public GeneralBooking(Student s, Event e, int size) {
        super(s, e, size);
    }
}

class VIPBooking extends Booking {
    public VIPBooking(Student s, Event e, int size) {
        super(s, e, size);
    }

    public double calculateTotal() {
        return super.calculateTotal() + 200;
    }
}

public class q1 {
    public static void main(String[] args) {
        Event ev = new Event("Football", "Stadium");
        Student s1 = new Student("student01", "101");
        Student s2 = new Student("student02", "102");

        GeneralBooking g = new GeneralBooking(s1, ev, 10);
        Ticket t1 = new Ticket("Football", 100);
        Ticket t2 = new Ticket("Football", 100);

        g.addTicket(t1);
        g.addTicket(t2, 2);

        System.out.println("General Booking:");
        g.printBooking();

        VIPBooking v = new VIPBooking(s2, ev, 10);
        Ticket t3 = new Ticket("Football VIP", 300);
        Ticket t4 = new Ticket("Football VIP", 300);

        v.addTicket(t3);
        v.addTicket(t4, 1);

        System.out.println("VIP Booking:");
        v.printBooking();
    }
}
