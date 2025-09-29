package lab05;

class Person {
    private String name;
    private String address;

    public Person(String n, String a) {
        name = n;
        address = a;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }

    @Override
    public String toString() {
        return "Person[name=" + name + ", address=" + address + "]";
    }
}

// Student subclass
class Student extends Person {
    private String major;

    public Student(String n, String a, String m) {
        super(n, a);
        major = m;
    }

    @Override
    public String toString() {
        return "Student[" + super.toString() + ", major=" + major + "]";
    }
}

class Employee extends Person {
    private String office;
    private double salary;

    public Employee(String n, String a, String o, double s) {
        super(n, a);
        office = o;
        salary = s;
    }

    @Override
    public String toString() {
        return "Employee[" + super.toString() + ", office=" + office + ", salary=" + salary + "]";
    }
}

class Faculty extends Employee {
    private String rank;

    public Faculty(String n, String a, String o, double s, String r) {
        super(n, a, o, s);
        rank = r;
    }

    @Override
    public String toString() {
        return "Faculty[" + super.toString() + ", rank=" + rank + "]";
    }
}


class Staff extends Employee {
    private String title;

    public Staff(String n, String a, String o, double s, String t) {
        super(n, a, o, s);
        title = t;
    }

    @Override
    public String toString() {
        return "Staff[" + super.toString() + ", title=" + title + "]";
    }
}

public class q3 {
    public static void main(String[] args) {
        Person p = new Person("Alice", "New York");
        Student st = new Student("Bob", "Boston", "Computer Science");
        Employee e = new Employee("Charlie", "Chicago", "Room 101", 50000);
        Faculty f = new Faculty("Diana", "Denver", "Room 202", 70000, "Professor");
        Staff s = new Staff("Eve", "Miami", "Room 303", 40000, "Administrator");

        System.out.println(p);
        System.out.println(st);
        System.out.println(e);
        System.out.println(f);
        System.out.println(s);
    }
}