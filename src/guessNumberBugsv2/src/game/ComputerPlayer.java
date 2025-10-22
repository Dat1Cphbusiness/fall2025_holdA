package game;

import java.util.Random;

public class ComputerPlayer implements Player {
    private Random random = new Random();

    @Override
    public int guessANumber(int min, int max) {
        int guess = random.nextInt(max - min + 1) + min;
        System.out.println("Computer gættede på " + guess);
        return guess;
    }
}
