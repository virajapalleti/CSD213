package pokemonSimulator.pokemon;

public class Vulpix extends Fire{
    private int specialMoveDamage;
    public Vulpix() {
        super("Vulpix", 100);
        specialMoveDamage = 50;
    }
    public int getSpecialMoveDamage() { return specialMoveDamage; }
}