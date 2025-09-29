package pokemonSimulator.pokemon;

public class Chikorita extends Grass{
    private int specialMoveDamage;
    public Chikorita() {
        super("Chikorita", 100);
        specialMoveDamage = 44;
    }
    public int getSpecialMoveDamage() { return specialMoveDamage; }
}