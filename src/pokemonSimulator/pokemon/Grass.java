package pokemonSimulator.pokemon;

abstract class Grass extends Pokemon {
    public Grass(String n, int h) { super(n, h); }
    public String getType() { return "Grass"; }
}
