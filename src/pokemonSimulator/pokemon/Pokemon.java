package pokemonSimulator.pokemon;

abstract public class Pokemon {
    private String name;
    private int health;

    public Pokemon(String n, int h) {
        name = n;
        health = h;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public abstract String getType();
}
