package pokemonSimulator.pokemon;

public class Squirtle extends Water{
    private int specialMoveDamage;
    public Squirtle() {
        super("Squirtle", 100);
        specialMoveDamage = 48;
    }
    public int getSpecialMoveDamage() { return specialMoveDamage; }
}