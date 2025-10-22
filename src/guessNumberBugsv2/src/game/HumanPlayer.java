package game;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public int guessANumber(int max, int min) {
        System.out.print("Gæt et tal mellem " + min + " og " + max + ": ");
        int guess = Integer.parseInt(scanner.nextLine());
        return guess;
    }
}