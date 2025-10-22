import game.ComputerPlayer;
import game.HumanPlayer;
import game.Player;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int min = 1;
        int max = 20;
        int numberToGuess = new Random().nextInt(max - min + 1) + min;
        System.out.println("Velkommen til Gæt et Tal!");
        System.out.println("Tallet ligger mellem " + min + " og " + max);
        System.out.println("------------------------------------");

        Player human = new HumanPlayer();
        Player computer = new ComputerPlayer();

        boolean guessed = false;

        while (!guessed) {

            // Human gæt
            int humanGuess = human.guessANumber(min, max);
            if (humanGuess == numberToGuess) {
                System.out.println("Menneske gættede rigtigt!");
            } else if (humanGuess < numberToGuess) {
                System.out.println("For lavt!");
            } else {
                System.out.println("For højt!");
            }

            // Computer gæt
            int computerGuess = computer.guessANumber(min, max);
            if (computerGuess == numberToGuess) {
                System.out.println("Computer gættede rigtigt!");
            } else if (computerGuess > numberToGuess) {
                System.out.println("Computer gættede for lavt!");
            } else {
                System.out.println("Computer gættede for højt!");
            }
        }
  }
}
