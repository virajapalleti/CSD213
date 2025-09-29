package pokemonSimulator;
import java.util.Scanner;
import pokemonSimulator.pokemon.*;
import pokemonSimulator.trainer.*;
import pokemonSimulator.oak.*;


public class battleground {
    private static OakJournal journal = new OakJournal(10);
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    addPokemon();
                    break;
                case 2:
                    addTrainer();
                    break;
                case 3:
                    journal.displayBadges();
                    break;
                case 4:
                    journal.runTournament();
                    break;
                case 5:
                    System.out.println("Thanks for playing Viraja's Pokemon Battleground (The ultimate)");
                    break;
                default: System.out.println("Invalid choice, try again.");
            }

            if (choice != 5) {
                System.out.println("\nPress Enter to continue...");
                input.nextLine();
                input.nextLine();
            }

        } while (choice != 5);
        }

    private static void showMenu() {
        System.out.println("\n================================");
        System.out.println("  WELCOME TO ULTIMATE POKEMON BATTLE SIMULATOR  ");
        System.out.println("1. Add Pokemon");
        System.out.println("2. Add Trainer");
        System.out.println("3. Display Badge Levels");
        System.out.println("4. Start Tournament");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");
    }

    private static void addPokemon() {
        System.out.print("pokemon name: ");
        String name = input.nextLine();
        System.out.print("type (Fire/Water/Grass/Electric): ");
        String type = input.nextLine();
        journal.addPokemon(name, type);
    }

    private static void addTrainer() {
        System.out.print("Trainer name: ");
        String name = input.next();

        Trainer trainer = new Trainer(name);

        System.out.println("Select 6 pokemons for " + name + ":");
        journal.displayAllPokemons();

        for (int i = 0; i < 6; i++) {
            System.out.print("Enter pokemon number for slot " + (i+1) + ": ");
            int pokemonIndex = input.nextInt();
            input.nextLine();
            Pokemon p = journal.getPokemon(pokemonIndex);
            if (p != null) {
                trainer.addPokemon(p, i);
            } else {
                System.out.println("Invalid");
                i--;
            }
        }

        journal.addTrainer(trainer);
        System.out.println("Trainer " + name + " added");
    }
}