package pokemonSimulator.pokemon;

abstract class Fire extends Pokemon {
    public Fire(String n, int h) { super(n, h); }
    public String getType() { return "Fire"; }
}