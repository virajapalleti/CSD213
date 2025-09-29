package lab05;
import java.util.*;

abstract class Game {
    protected String name;
    protected int maxMoves, moves;
    public Game(String name, int maxMoves) {
        this.name = name;
        this.maxMoves = maxMoves;
        this.moves = 0;
    }
    public void start() {
        moves = 0;
    }
    public abstract String processKey(char key);
}

class FlightSimple extends Game {
    private int speed, altitude;
    public FlightSimple(int maxMoves) {
        super("FlightSimple", maxMoves);
        speed = 0;
        altitude = 0;
    }
    @Override
    public String processKey(char key) {
        moves++;
        switch (key) {
            case 'R': speed++; break;
            case 'L':
                speed--;
                if (speed < 0) speed = 0;
                if (altitude > 0 && speed == 0) return "Lost";
                break;
            case 'U':
                if (speed > 2) altitude++;
                break;
            case 'D':
                altitude--;
                if (altitude < 0) return "Lost";
                break;
        }
        if (altitude == 0 && speed == 0 && moves > 0) return "Won";
        if (moves >= maxMoves) return "Game Over";
        return "None";
    }
}

class RandomWalk extends Game {
    private int x, y;
    public RandomWalk(int maxMoves) {
        super("RandomWalk", maxMoves);
        x = 10; y = 10;
    }
    @Override
    public String processKey(char key) {
        moves++;
        switch (key) {
            case 'L': if (x > 0) x--; break;
            case 'R': x++; break;
            case 'U': y++; break;
            case 'D': y--; break;
        }
        if (x > 19 || y > 19) return "Lost";
        if (y == 0) return "Won";
        if (moves >= maxMoves) return "Game Over";
        return "None";
    }
}

class GameConsole {
    public void play(String gameName, int maxMoves, String keys) {
        Game game;
        if (gameName.equals("FlightSimple")) {
            game = new FlightSimple(maxMoves);
        } else if (gameName.equals("RandomWalk")) {
            game = new RandomWalk(maxMoves);
        } else {
            System.out.println("Game not found!");
            return;
        }
        game.start();
        for (char key : keys.toCharArray()) {
            String result = game.processKey(key);
            if (!result.equals("None")) {
                System.out.println(gameName + ": " + result);
                return;
            }
        }
    }
}

public class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameConsole console = new GameConsole();
        while (true) {
            System.out.print("Enter game name (FlightSimple/RandomWalk/End): ");
            String gname = sc.next();
            if (gname.equals("End")) break;
            System.out.print("Enter max moves: ");
            int max = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter sequence of keys (e.g. RRULD): ");
            String keys = sc.nextLine().replace(" ", "");
            console.play(gname, max, keys);
        }
        sc.close();
    }
}