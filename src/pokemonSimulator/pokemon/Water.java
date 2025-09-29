package pokemonSimulator.pokemon;

abstract class Water extends Pokemon {
    public Water(String n, int h) { super(n, h); }
    public String getType() { return "Water"; }
}