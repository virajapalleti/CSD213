package labassignments.lab06;
import java.util.*;


interface Saveable {
    ArrayList<String> write();
    void read(ArrayList<String> data);
}

class Player implements Saveable {
    private String name;
    private int level;
    private int health;
    private String weapon;


    public Player(String name, int level, int health, String weapon) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.weapon = weapon;
    }


    public Player() {
        this("Unknown", 1, 100, "None");
    }

    @Override
    public ArrayList<String> write() {
        ArrayList<String> values = new ArrayList<>();
        values.add(name);
        values.add(String.valueOf(level));
        values.add(String.valueOf(health));
        values.add(weapon);
        return values;
    }

    @Override
    public void read(ArrayList<String> data) {
        if (data != null && data.size() >= 4) {
            name = data.get(0);
            level = Integer.parseInt(data.get(1));
            health = Integer.parseInt(data.get(2));
            weapon = data.get(3);
        }
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', level=" + level +
                ", health=" + health + ", weapon='" + weapon + "'}";
    }
}

class Monster implements Saveable {
    private String type;
    private int strength;
    private int hitPoints;

    public Monster(String type, int strength, int hitPoints) {
        this.type = type;
        this.strength = strength;
        this.hitPoints = hitPoints;
    }

    public Monster() {
        this("Goblin", 10, 50);
    }

    @Override
    public ArrayList<String> write() {
        ArrayList<String> values = new ArrayList<>();
        values.add(type);
        values.add(String.valueOf(strength));
        values.add(String.valueOf(hitPoints));
        return values;
    }

    @Override
    public void read(ArrayList<String> data) {
        if (data != null && data.size() >= 3) {
            type = data.get(0);
            strength = Integer.parseInt(data.get(1));
            hitPoints = Integer.parseInt(data.get(2));
        }
    }

    @Override
    public String toString() {
        return "Monster{type='" + type + "', strength=" + strength +
                ", hitPoints=" + hitPoints + "}";
    }
}

public class q1 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Player player1 = new Player("Hero", 5, 100, "Sword");
        Monster monster1 = new Monster("Dragon", 50, 200);

        System.out.println("Original Objects:");
        System.out.println(player1);
        System.out.println(monster1);

        System.out.println("\n--- Saving Objects ---");
        saveObject(player1);
        saveObject(monster1);

        Player player2 = new Player();
        Monster monster2 = new Monster();

        System.out.println("\n--- Restoring Objects ---");
        System.out.println("Enter values for Player (name, level, health, weapon):");
        loadObject(player2);

        System.out.println("Enter values for Monster (type, strength, hitPoints):");
        loadObject(monster2);

        System.out.println("\n--- Restored Objects ---");
        System.out.println(player2);
        System.out.println(monster2);
    }

    public static void saveObject(Saveable object) {
        System.out.println("Saving: " + object.getClass().getSimpleName());
        ArrayList<String> values = object.write();
        System.out.println("Values to save: " + values);
    }

    public static void loadObject(Saveable object) {
        ArrayList<String> values = readValues();
        object.read(values);
        System.out.println("Object loaded successfully!");
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();
        System.out.println("Enter values (type 'done' when finished):");

        while (true) {
            String input = q1.input.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            values.add(input);
        }

        return values;
    }
}