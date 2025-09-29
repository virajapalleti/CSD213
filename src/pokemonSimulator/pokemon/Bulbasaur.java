package pokemonSimulator.pokemon;

public class Bulbasaur extends Grass{
    private int specialMoveDamage;
    public Bulbasaur() {
        super("Bulbasaur", 100);
        specialMoveDamage = 46;
    }
    public int getSpecialMoveDamage() { return specialMoveDamage; }
}