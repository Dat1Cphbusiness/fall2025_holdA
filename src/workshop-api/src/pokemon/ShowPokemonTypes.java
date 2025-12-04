package pokemon;

import java.io.IOException;
import java.util.Scanner;

public class ShowPokemonTypes {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Indtast Pokémon-navn: ");
        String name = sc.nextLine();
        name = "abomasnow";

        Pokemon p = PokeApiHelper.fetchPokemon(name);

        if (p == null) {
            return;
        }

        System.out.println("\nNavn: " + p.name);
        System.out.println("Typer:");

        for (TypeEntry entry : p.types) {
            System.out.println(" - " + entry.type.name);
        }
    }
}
