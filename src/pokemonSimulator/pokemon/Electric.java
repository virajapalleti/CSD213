package pokemonSimulator.pokemon;

abstract class Electric extends Pokemon {
    public Electric(String n, int h) { super(n, h); }
    public String getType() { return "Electric"; }
}