package guessNumberGames;

import java.util.Scanner;
import java.util.Random;

public class GuessNumber_Recursive{
	
	private static int secretNumber;  
	
	public static void main (String[] args) {

		// Program laver tilfældigt tal ml 1-100	
		Random random = new Random();
		secretNumber = random.nextInt(100)+1;
		System.out.println("Kun til test - det tilfældige tal: " + secretNumber);
		System.out.println( "Gæt et tal ml. 1 and 100");
		
        makeAGuess(1); //1 indicates first attempt
	}	
	
	 // Recursive guessing
     static void makeAGuess(int attempt) {		
		Scanner scanner =  new Scanner(System.in);
        int userGuess = scanner.nextInt();
        if (userGuess == secretNumber) {
            System.out.println("Correct! You guessed it in "+ attempt + " attempt(s).");
            return; //end program
        } else if (userGuess < secretNumber) {
            System.out.println("Too low. Try again.");
        } else {
            System.out.println("Too high. Try again.");
        }
        // recursion: call again with incremented attempt count
        makeAGuess(attempt + 1);
    }
			
}