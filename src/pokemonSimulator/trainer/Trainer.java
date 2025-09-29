package pokemonSimulator.trainer;
import pokemonSimulator.pokemon.*;

public class Trainer {
    private String name;
    private Pokemon[] pokemons = new Pokemon[6];
    private int badgeCount = 50;
    private int consecutiveLosses = 0;
    private boolean alive = true;

    public Trainer(String n) { name = n; }

    public String getName() { return name; }
    public int getBadgeCount() { return badgeCount; }
    public Pokemon[] getTeam() { return pokemons; }
    public boolean isAlive() { return alive; }

    public void addPokemon(Pokemon p, int slot) {
        if (slot >= 0 && slot < 6) {
            pokemons[slot] = p;
        }
    }

    public void winShowdown() {
        badgeCount++;
        consecutiveLosses = 0;
    }

    public void loseShowdown() {
        badgeCount--;
        consecutiveLosses++;
        if (consecutiveLosses >= 3) {
            alive = false;
        }
    }
}