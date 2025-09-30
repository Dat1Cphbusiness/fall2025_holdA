package guessNumberGames;

import java.util.Scanner;
import java.util.Random;

public class GuessNumber_While_Loop {
	
	 public static void main (String[] args) {

		// Program laver tilfældigt tal ml 1-100	
		Random random = new Random();
		int secretNumber = random.nextInt(100)+1;
		System.out.println("Kun til test - det tilfældige tal: " + secretNumber);

		//Bruger gætter på tal (indlæs int med nextInt()
		Scanner scanner = new Scanner(System.in);

		int userGuess = 0;
		int attempts = 0;
		final int MAX_ATTEMPTS = 10;
			
		System.out.println("Du har  " + MAX_ATTEMPTS + " forsøg på at gætte mit tal");
					
		// loop indtil bruger gætter rigtigt
		while (userGuess != secretNumber && attempts < MAX_ATTEMPTS) {
			System.out.println("Gæt på tal ml 1-100");			
			userGuess = scanner.nextInt();	
			attempts++;
			
			if (userGuess == secretNumber) {
				System.out.println("Du gættede rigtigt. Tallet er " + secretNumber);
			} else {
					System.out.println("Forkert.");
					System.out.println("Forsøg tilbage: " + (MAX_ATTEMPTS - attempts));
				}
			}

			if (userGuess != secretNumber ) {
				System.out.println("Game Over");
			
			}
	}	
			
}