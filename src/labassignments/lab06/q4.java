package labassignments.lab06;
import java.util.Scanner;

class FatherNameException extends Exception {
    public String toString() {
        return "Error: father must have a name";
    }
}

class AgeException extends Exception {
    public String toString() {
        return "Error: age must be between 0 and 100.";
    }
}

class Father {
    String fatherName;
    int fatherAge;

    Father(String name, int age) throws FatherNameException, AgeException {
        if (name.equals("")) throw new FatherNameException();
        if (age < 0 || age > 100) throw new AgeException();

        this.fatherName = name;
        this.fatherAge = age;
    }
}

class Child extends Father {
    String childName;
    int childAge;

    Child(String fName, int fAge, String cName, int cAge) throws FatherNameException, AgeException {
        super(fName, fAge);

        if (cAge < 0 || cAge > 100) throw new AgeException();

        this.childName = cName;
        this.childAge = cAge;
    }

    public void display() {
        System.out.println("Father: " + fatherName + " ( age: " + fatherAge + ")");
        System.out.println("Child: " + childName + " (age: " + childAge + ")");
    }
}

public class q4 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("father's name: ");
        String f_name = input.nextLine();

        System.out.print("father's age: ");
        int f_age = input.nextInt();
        input.nextLine();

        System.out.print("child's name: ");
        String c_name = input.nextLine();

        System.out.print("child's age: ");
        int c_age = input.nextInt();

        Child obj = new Child(f_name, f_age, c_name, c_age);
        obj.display();

        input.close();
    }
}
