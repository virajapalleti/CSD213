package pokemonSimulator.pokemon;

public class Pikachu extends Electric{
    private int specialMoveDamage;
    public Pikachu() {
        super("Pikachu", 100);
        specialMoveDamage = 55;
    }
    public int getSpecialMoveDamage() { return specialMoveDamage; }
}