package gameio;

import java.io.FileNotFoundException;

public class Main {
    static TextUI ui = new TextUI();
    static Game game;
    public static void main(String[] args) {
        ui.displayMessage("Welcome to the game");
        String input = ui.promptText("New game (n) or load game (l)?");
        if(input.equals("n")){
            newGame();
        }
        else{
            loadGame();
        }
        game.displayPlayers();
    }

    public static void loadGame(){
        String input = ui.promptText("What is the name of your game?");
        game = new Game();
        game.loadGame(input);
      /*  try {
            game.loadGame2(input);
        } catch (FileNotFoundException e) {
            input = ui.promptText("Spillet findes ikke. Prøv igen");
            try {
                game.loadGame2(input);
            } catch (FileNotFoundException ex) {
                ui.displayMessage("The program will terminate");
            }
        }*/
    }

    public static void newGame(){
        int noOfPlayers = ui.promptNumeric("How many players are you?");
        game = new Game("Yatzy", noOfPlayers);
        for(int i = 0; i < noOfPlayers; i++){
            game.registerPlayer();
        }
        game.displayPlayers();
    }
}
