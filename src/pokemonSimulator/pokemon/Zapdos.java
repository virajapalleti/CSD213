package pokemonSimulator.pokemon;

public class Zapdos extends Electric{
    private int specialMoveDamage;
    public Zapdos() {
        super("Zapdos", 100);
        specialMoveDamage = 60;
    }
    public int getSpecialMoveDamage() { return specialMoveDamage; }
}