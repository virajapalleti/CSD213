package pokemonSimulator.oak;
import pokemonSimulator.pokemon.*;
import pokemonSimulator.trainer.*;

public class OakJournal {
    private Trainer[] trainers;
    private int trainerCount = 0;
    private Pokemon[] allPokemons;

    public OakJournal(int maxTrainers) {
        trainers = new Trainer[maxTrainers];
        initializePokemons();
    }

    private void initializePokemons() {
        allPokemons = new Pokemon[8];
        allPokemons[0] = new Charmander();
        allPokemons[1] = new Vulpix();
        allPokemons[2] = new Squirtle();
        allPokemons[3] = new Psyduck();
        allPokemons[4] = new Bulbasaur();
        allPokemons[5] = new Chikorita();
        allPokemons[6] = new Pikachu();
        allPokemons[7] = new Zapdos();
    }

    public void addTrainer(Trainer t) {
        if (trainerCount < trainers.length) {
            trainers[trainerCount] = t;
            trainerCount++;
        }
    }

    public int getTrainerCount() { return trainerCount; }

    public void addPokemon(String name, String type) {
        if (!type.equals("Fire") && !type.equals("Water") && !type.equals("Grass") && !type.equals("Electric")) {
            System.out.println("Only Fire, Water, Grass, and Electric types are allowed!");
            return;
        }

        Pokemon newPokemon = null;

        if (type.equals("Fire")) {
            newPokemon = new Pokemon(name, 100) {
                private int specialMoveDamage = 40;
                public String getType() { return "Fire"; }
                public int getSpecialMoveDamage() { return specialMoveDamage; }
            };
        } else if (type.equals("Water")) {
            newPokemon = new Pokemon(name, 100) {
                private int specialMoveDamage = 50;
                public String getType() { return "Water"; }
                public int getSpecialMoveDamage() { return specialMoveDamage; }
            };
        } else if (type.equals("Grass")) {
            newPokemon = new Pokemon(name, 100) {
                private int specialMoveDamage = 45;
                public String getType() { return "Grass"; }
                public int getSpecialMoveDamage() { return specialMoveDamage; }
            };
        } else if (type.equals("Electric")) {
            newPokemon = new Pokemon(name, 100) {
                private int specialMoveDamage = 48;
                public String getType() { return "Electric"; }
                public int getSpecialMoveDamage() { return specialMoveDamage; }
            };
        }

        if (newPokemon != null) {
            Pokemon[] temp = new Pokemon[allPokemons.length + 1];
            for (int i = 0; i < allPokemons.length; i++) {
                temp[i] = allPokemons[i];
            }
            temp[allPokemons.length] = newPokemon;
            allPokemons = temp;
            System.out.println(name + " added successfully!");
        }
    }

    public void displayAllPokemons() {
        System.out.println("Available Pokemons:");
        for (int i = 0; i < allPokemons.length; i++) {
            System.out.println(i + ": " + allPokemons[i].getName() + " (" + allPokemons[i].getType() + ")");
        }
    }

    public Pokemon getPokemon(int index) {
        if (index >= 0 && index < allPokemons.length) {
            String name = allPokemons[index].getName();
            String type = allPokemons[index].getType();

            if (name.equals("Charmander")) return new Charmander();
            else if (name.equals("Vulpix")) return new Vulpix();
            else if (name.equals("Squirtle")) return new Squirtle();
            else if (name.equals("Psyduck")) return new Psyduck();
            else if (name.equals("Bulbasaur")) return new Bulbasaur();
            else if (name.equals("Chikorita")) return new Chikorita();
            else if (name.equals("Pikachu")) return new Pikachu();
            else if (name.equals("Zapdos")) return new Zapdos();
            else {
                if (type.equals("Fire")) {
                    return new Pokemon(name, 100) {
                        private int specialMoveDamage = 40;
                        public String getType() { return "Fire"; }
                        public int getSpecialMoveDamage() { return specialMoveDamage; }
                    };
                } else if (type.equals("Water")) {
                    return new Pokemon(name, 100) {
                        private int specialMoveDamage = 50;
                        public String getType() { return "Water"; }
                        public int getSpecialMoveDamage() { return specialMoveDamage; }
                    };
                } else if (type.equals("Grass")) {
                    return new Pokemon(name, 100) {
                        private int specialMoveDamage = 45;
                        public String getType() { return "Grass"; }
                        public int getSpecialMoveDamage() { return specialMoveDamage; }
                    };
                } else if (type.equals("Electric")) {
                    return new Pokemon(name, 100) {
                        private int specialMoveDamage = 48;
                        public String getType() { return "Electric"; }
                        public int getSpecialMoveDamage() { return specialMoveDamage; }
                    };
                }
            }
        }
        return null;
    }

    public void runTournament() {
        if (trainerCount < 2) {
            System.out.println("Need at least 2 trainers for tournament!");
            return;
        }

        System.out.println("Tournament started");
        for (int i = 0; i < trainerCount; i++) {
            for (int j = i + 1; j < trainerCount; j++) {
                if (trainers[i].isAlive() && trainers[j].isAlive()) {
                    runShowdown(trainers[i], trainers[j]);
                }
            }
        }
        System.out.println("Tournament has been completed:");
        displayBadges();
    }

    public void runShowdown(Trainer t1, Trainer t2) {
        System.out.println("\nShowdown: " + t1.getName() + " vs " + t2.getName());

        int t1Wins = 0;
        int t2Wins = 0;

        for (int i = 0; i < 6; i++) {
            Pokemon p1 = t1.getTeam()[i];
            Pokemon p2 = t2.getTeam()[i];

            if (p1 == null || p2 == null) continue;

            int result = battle(p1, p2);

            if (result == 1) {
                t1Wins++;
                System.out.println("Battle " + (i+1) + ": " + p1.getName() + " vs " + p2.getName() + " - Winner: " + t1.getName());
            } else if (result == 2) {
                t2Wins++;
                System.out.println("Battle " + (i+1) + ": " + p1.getName() + " vs " + p2.getName() + " - Winner: " + t2.getName());
            } else {
                System.out.println("Battle " + (i+1) + ": " + p1.getName() + " vs " + p2.getName() + " - Draw");
            }
        }

        if (t1Wins > t2Wins) {
            System.out.println("Showdown Winner: " + t1.getName());
            t1.winShowdown();
            t2.loseShowdown();
        } else if (t2Wins > t1Wins) {
            System.out.println("Showdown Winner: " + t2.getName());
            t2.winShowdown();
            t1.loseShowdown();
        } else {
            System.out.println("Showdown Draw");
        }

        if (!t1.isAlive()) System.out.println(t1.getName() + " died. They proved to be weak!");
        if (!t2.isAlive()) System.out.println(t2.getName() + " died. They proved to be weak!");
    }

    private int battle(Pokemon p1, Pokemon p2) {
        String type1 = p1.getType();
        String type2 = p2.getType();

        if (type1.equals("Fire") && type2.equals("Grass")) return 1;
        if (type2.equals("Fire") && type1.equals("Grass")) return 2;
        if (type1.equals("Grass") && type2.equals("Water")) return 1;
        if (type2.equals("Grass") && type1.equals("Water")) return 2;
        if (type1.equals("Water") && type2.equals("Fire")) return 1;
        if (type2.equals("Water") && type1.equals("Fire")) return 2;
        if (type1.equals("Electric") && type2.equals("Water")) return 1;
        if (type2.equals("Electric") && type1.equals("Water")) return 2;
        if (type1.equals("Grass") && type2.equals("Electric")) return 1;
        if (type2.equals("Grass") && type1.equals("Electric")) return 2;
        if (type1.equals("Fire") && type2.equals("Electric")) return 1;
        if (type2.equals("Fire") && type1.equals("Electric")) return 2;

        if (p1.getHealth() > p2.getHealth()) return 1;
        if (p2.getHealth() > p1.getHealth()) return 2;
        return 0;
    }

    public void displayBadges() {
        System.out.println("\nBadge Counts:");
        for (int i = 0; i < trainerCount; i++) {
            System.out.println(trainers[i].getName() + ": " + trainers[i].getBadgeCount() + " badges");
        }
    }
}