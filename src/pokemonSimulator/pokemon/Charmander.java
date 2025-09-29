package pokemonSimulator.pokemon;

public class Charmander extends Fire{
    private int specialMoveDamage;
    public Charmander() {
        super("Charmander", 100);
        specialMoveDamage = 45;
    }
    public int getSpecialMoveDamage() { return specialMoveDamage; }
}