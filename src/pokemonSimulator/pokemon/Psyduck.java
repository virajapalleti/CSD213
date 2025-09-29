package pokemonSimulator.pokemon;

public class Psyduck extends Water{
    private int specialMoveDamage;
    public Psyduck() {
        super("Psyduck", 100);
        specialMoveDamage = 42;
    }
    public int getSpecialMoveDamage() { return specialMoveDamage; }
}